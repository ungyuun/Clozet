import React, { useState, useEffect, useRef } from "react";
import {useInfiniteQuery,useQueryClient} from "react-query";
import { useInView } from "react-intersection-observer";
import { useLocation,useNavigate } from "react-router-dom";
import axiosInstance from "../../common/AxiosInstance";
import MyPurchase from "./MyPurchase";

const PurchaseList = () => {
  
  const [ref,inView] = useInView();
  const location = useLocation();

  const { data, status, fetchNextPage, hasNextPage, isFetchingNextPage } =
    useInfiniteQuery("purchases", ({ pageParam = 0 }) => getProduct(pageParam), {
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
      try {
          const res = await axiosInstance.get(`${process.env.PUBLIC_URL}/api/purchase/list?page=${page}`, {
            params: {
              pathname: location.pathname,
            },
          });
          const result = res.data;
          console.log(res);
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
  useEffect(() => {
    if (inView && hasNextPage) {
      fetchNextPage({
        page: data.nextPage,
      });
    }
  }, [inView, hasNextPage]);

  return (
    <><br/><br/>
      <h4>구매목록</h4><hr/>
         {data ? (
          data.pages.map((item) =>
            item.result.map((list, idx) =>
              
                <MyPurchase lastItemRef={idx === item.result.length - 1 ? ref : null} index={idx} data={list} />
              )
            )
        ) : (
          <div>Loading...</div>
        )} 
    </>
  );
    
}

export default PurchaseList;