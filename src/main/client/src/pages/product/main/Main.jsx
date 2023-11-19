import React, { useState, useEffect, useRef } from "react";
import {useInfiniteQuery,useQueryClient} from "react-query";
import { useInView } from "react-intersection-observer";
import axios from "axios";

import Card from "./Card";
//https://s0ojin.tistory.com/58 참고
function Main() {
  
  const [ref,inView] = useInView();
  const [searchKeyword, setSearchKeyword] = useState("");

  const queryClient = useQueryClient();

  const { data, status, fetchNextPage, hasNextPage, isFetchingNextPage } =
    useInfiniteQuery("products", ({ pageParam = 0 }) => getProduct(pageParam, searchKeyword), {
      select: data => ({
        pages: data.pages,
        nextPage: data.pages.length+1,
        pageParam: data.pageParams,
      }),
      getNextPageParam: (lastPage, allPages) => {
        const nextPage = allPages.length;
        return lastPage.nextPage === 0 ? undefined : nextPage;},
    });

    async function getProduct(page, keyword) {
      try {
          const res = await axios.get(`${process.env.PUBLIC_URL}/api/product/main?page=${page}&keyword=${keyword || ""}`);
          const result = res.data;
          console.log(result);
          return {
              result: result.content,
              isLast: res.data.last
          };
      } catch (error) {
          console.error("Error:", error);
          if (error.response) {
              // 서버에서 반환한 응답이 있는 경우 응답 상태 코드와 데이터를 출력
              console.error("Response Status:", error.response.status);
              console.error("Response Data:", error.response.data);
          }
          // 에러 메시지를 사용자에게 표시하거나 다른 조치를 취할 수 있음
      }
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    queryClient.removeQueries('products');
    // 검색 버튼이 클릭될 때 검색어를 상태로 설정하고 새로운 페이지를 가져옵니다.
    fetchNextPage({ pageParam: 0 });
    
  };
  useEffect(() => {
    if (inView && hasNextPage) {
      fetchNextPage({
        page: data.nextPage,
      });
    }
  }, [inView, hasNextPage]);

  return (
    <><br/><br/>
        <div className="d-flex justify-content-between">
            <h4 className="text-start">제품</h4>
            <form className="d-flex ml-5 text-end" role="search" onSubmit={handleSubmit}>
              <input
                className="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
                value={searchKeyword}
                onChange={(e) => setSearchKeyword(e.target.value)}
              ></input>
              <button className="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
        </div>
      
      <hr/>
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
    </>
  );
    
}

export default Main;