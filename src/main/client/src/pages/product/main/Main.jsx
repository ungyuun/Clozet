import React, { useState, useEffect, useRef } from "react";
import {useInfiniteQuery,useQueryClient} from "react-query";
import { useInView } from "react-intersection-observer";
import axios from "axios";

// import End from "./End";
import Card from "./Card";
// import { FormProvider } from "react-hook-form";

function Main() {
  
  const [now,setNow] = useState(0);
  const [ref,inView] = useInView();
  const queryClient = useQueryClient();
  const { data, status, fetchNextPage, hasNextPage, isFetchingNextPage } =
    useInfiniteQuery("products", ({ page = 0 }) => getProduct(now), {
      refetchOnWindowFocus: true,
      getNextPageParam: (lastPage, allPages) => {
        if (!lastPage.isLast) {
          console.log(`last: ${lastPage.nextPage}`)
          return lastPage.nextPage;
        } else {
          return undefined;
        }
      },
    });

  async function getProduct(page) {
    const res = await axios.get(`http://localhost:8081/product/main?page=${page}`);
    const result = res.data;
    console.log(result);
    setNow(now+1);
    return {
      result: result.content,
      nextPage: now + 1,
      isLast: res.data.last
    };
  
  }
  useEffect(() => {
    console.log(data)
    if (inView && hasNextPage) {
      fetchNextPage({
        page: data.nextPage,
      });
    }
  }, [inView, hasNextPage]);
  useEffect(() => {
    console.log(inView);
  }, [inView]);
  useEffect(() => {
    return () => {
      // 페이지를 떠날 때 데이터 초기화
      queryClient.invalidateQueries("products");
    };
  }, []);

  return (
    // <div>
    //   {data ? (
    //     <Card lastItemRef={ref} listdata={data.pages.map((item) => item.result).flat()} />
    //   ) : (
    //     <div>Loading...</div>
    //   )}
    // </div>
    <div style={{ display: "grid", gridTemplateColumns: "repeat(3, 1fr)", gap: "16px" }}>
      {data ? (
        data.pages.map((item) =>
          item.result.map((list, idx) =>
            
              <Card  lastItemRef={idx === item.result.length - 1 ? ref : null} index={idx} data={list} />
            )
          )
      ) : (
        <div>Loading...</div>
      )}
    
    </div>
  );
    
}

export default Main;
