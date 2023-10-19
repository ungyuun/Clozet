import React, { useState, useEffect, useRef } from "react";
import {useInfiniteQuery,useQueryClient} from "react-query";
import { useInView } from "react-intersection-observer";
import axios from "axios";

import Card from "./Card";
//https://s0ojin.tistory.com/58 참고
function Main() {
  
  const [ref,inView] = useInView();

  const { data, status, fetchNextPage, hasNextPage, isFetchingNextPage } =
    useInfiniteQuery("products", ({ pageParam = 0 }) => getProduct(pageParam), {
      select: data => ({
        pages: data.pages,
        nextPage: data.pages.length+1,
        pageParam: data.pageParams,
      }),
      getNextPageParam: (lastPage, allPages) => {
        const nextPage = allPages.length;
        return lastPage.nextPage === 0 ? undefined : nextPage;},
    });

  async function getProduct(page) {
    const res = await axios.get(`http://localhost:8081/product/main?page=${page}`);
    const result = res.data;
    console.log(result)
    return {
      result: result.content,
      isLast: res.data.last
    };
  
  }
  useEffect(() => {
    if (inView && hasNextPage) {
      fetchNextPage({
        page: data.nextPage,
      });
    }
  }, [inView, hasNextPage]);

  return (
    <div  style={{ display: "grid", gridTemplateColumns: "repeat(3, 1fr)", gap: "16px" }}>
      {data ? (
        data.pages.map((item) =>
          item.result.map((list, idx) =>
            
              <Card  className="card" lastItemRef={idx === item.result.length - 1 ? ref : null} index={idx} data={list} />
            )
          )
      ) : (
        <div>Loading...</div>
      )}
    
    </div>

  );
    
}

export default Main;