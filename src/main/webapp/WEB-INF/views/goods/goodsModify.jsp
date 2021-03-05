<%@ page import="com.dessert.ringring.domain.DTOGoods" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%DTOGoods goods= (DTOGoods) session.getAttribute("goods");%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Insert title here</title>
 </head>
 <body>
 <form method="post"  action="/goods/goodsModify">
  <div class="status"></div>
  <table class="joinform">


   <tr>
    <th class="tt">이름</th>
    <td>
     <input type="text" name="name" value maxlength="16" label="이름">
    </td>
   </tr>

   <tr>
    <th class="tt">가격</th>
    <td><input type="text" name="price" value maxlength="16" label="가격" placeholder="가격 입력해주세요"></td>
   </tr>


   <tr>
    <th class="tt">중량</th>
    <td><input type="text" name="weight" value maxlength="16" label="중량" placeholder="중량을 입력해주세요"></td>
   </tr>


   <tr>
    <th class="tt">재고</th>
    <td><input type="text" name="stock" value maxlength="16" label="재고" placeholder="숫자 입력해주세요"></td>
   </tr>

   <tr>
    <th class="tt">설명</th>
    <td><input type="text" name="detail" value maxlength="16" label="설명" placeholder="숫자 입력해주세요"></td>
   </tr>

   <tr>
    <th class="tt">짧은설명</th>
    <td><input type="text" name="shortDetail" value maxlength="16" label="짧은설명" plaeholder="숫자 입력해주세요"></td>
   </tr>

   <tr>
    <th class="tt">대분류</th>
    <td><input type="text" name="category1" value maxlength="16" label="대분류" plaeholder="대분류 입력해주세요"></td>
   </tr>

   <tr>
    <th class="tt">소분류</th>
    <td><input type="text" name="category2" value maxlength="16" label="소분류" plaeholder="소분류 입력해주세요"></td>
   </tr>

  </table>
  <div id="formSubmit">
   <button type="submit">등록하기</button>
  </div>
 </form>
 </body>
 </html>