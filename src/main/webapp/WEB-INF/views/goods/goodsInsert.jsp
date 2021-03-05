 <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html lang="en">
 <head>
 <meta charset="UTF-8">
 <title>Insert title here</title>
 </head>
 <body>
 <form method="post" id="authForm" action="/insertGoods" enctype="multipart/form-data">
  <div class="status"></div>
  <table class="joinform">

   <tr>
    <td>
     <div class="input-group mb-1">
      <div class="input-group-prepend">
       <span class="input-group-text">대표이미지</span>
      </div>

      <div class="custom-file">
       <input type="file" name="file" id="file" aria-describedby="inputGroupFileAddon01">
       <label class="custom-file-label" for="inputGroupFile01"></label>
      </div>
     </div>
     <%=request.getRealPath("/")%>
     <script>
      $("#file").change(function(){
       if(this.files&&this.files[0]){
        var reader=new FileReader;
        reader.onload=function (data){
         $(".select_img img").attr("src",data.target.result).width(400);
        }
        reader.readAsDataURL(this.files[0]);
       }
      });
     </script>



    </td>
   </tr>
   <tr>
    <td>
     <div class="input-group mb-1">
      <div class="input-group-prepend">
       <span class="input-group-text" id="inputGroupFileAddon01">상세이미지</span>
      </div>
      <div class="custom-file">
       <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
       <label class="custom-file-label" for="inputGroupFile01"></label>
      </div>
     </div>

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
    <td><input type="text" name="detail" value maxlength="16" label="설명" placeholder="설명 입력해주세요"></td>
   </tr>

   <tr>
    <th class="tt">짧은설명</th>
    <td><input type="text" name="shortDetail" value maxlength="16" label="짧은설명" plaeholder="짧은설명 입력해주세요"></td>
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