<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.dessert.ringring.domain.DTOCart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%ArrayList<DTOCart> list= (ArrayList<DTOCart>) session.getAttribute("list");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/shop-basket.css">
</head>
<body>
<div class = "checkbox_group">

    <h2 class="tt">장바구니</h2>

    <div class="bst_top">
        <input class="" type="checkbox" name="exampleRadios" id="check_all" value="option1">
        <label class="form-check-label" for="check_all"> 전체선택</label>
        <p class="spc">I</p>
        <p class="del">선택삭제</p>
    </div>

    <div class="status"></div>
    <c:forEach items="${list}" var="list">
    <div class="basket_product pro1">

        <!-- checkbox -->
        <div class="bst_checkbox pro_bst">
            <input class="" type="checkbox" name="exampleRadios" id="cart1" value="option1">
        </div>

        <!-- image -->
        <div class="bst_image pro_bst">
            <img src="${list.img}" style="width: 120px; height: 150px;">
        </div>

        <!-- name -->
        <div class="bst_name pro_bst">
            <label class="form-check-label" for="cart1">
                <p class="tt name">${list.name}</p>
                <p class="st price">${list.price}원</p>
            </label>
        </div>

        <!-- button -->
        <div class="bst_button pro_bst">
            <button type="button" class="plus">
                <i class="fa fa-plus-square-o"></i>
            </button>
            <input type="number" class="numBox" min="1" max="100" value=${list.amount} readonly="readonly"/>
            <button type="button" class="minus">
                <i class="fa fa-minus-square-o"></i>
            </button>
        </div>

    </div>
    </c:forEach>


    <div class="status"></div>
    <!-- ======선택 팝업창 띄우는 코드 bst_top 선택삭제에다가 적용 -->
    <a href="#">
        <button type="button" class="Dele" style="width: 60px;font-size: 12px;padding: 3px;height: 30px;
        border-radius: 3px; background-color: #df404a; color: #ffffff;border: none; margin: 10px 0px 30px 0px ">선택삭제</button>
    </a>
</div>
<div class="bst-total">
    <table id="total">
        <tr>
            <td class="tt tit">상품금액</td>
            <td class="tt sub">535,000원</td>
        </tr>
        <tr>
            <td class="tt tit">상품할인금액</td>
            <td class="tt sub">0원</td>
        </tr>
        <tr>
            <td class="tt tit">배송비</td>
            <td class="tt sub">3000원</td>
        </tr>
    </table>
    <table id="last_total">
        <tr>
            <td class="tt tit">결제예정금액</td>
            <td class="tt sub">538,000원</td>
        </tr>
    </table>
</div>
<div class="total_btn">
    <button type="button" class="put_btn">주문하기</button>
</div>

</body>

<!-- =====================js 실행 ======================== -->

<script src ="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../static/js/bootstrap.js"></script>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
<script>

    //체크박스 전체선택
    $(".checkbox_group").on("click", "#check_all", function () {
        $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
    });

    // 체크박스 개별 선택
    $(".checkbox_group").on("click", ".form-check-input", function() {
        var is_checked = true;

        $(".checkbox_group .form-check-input").each(function(){
            is_checked = is_checked && $(this).is(":checked");
        });

        $("#check_all").prop("checked", is_checked);
    });
    //수량체크
    $(".plus").on("click",(function(){
        var num = $(".numBox").val();
        var plusNum = Number(num) + 1;

        if(plusNum >= 100) {
            $(".numBox").val(num);
        } else {
            $(".numBox").val(plusNum);
        }
    }));
    $(".minus").click(function(){
        var num = $(".numBox").val();
        var minusNum = Number(num) - 1;

        if(minusNum <= 1) {
            $(".numBox").val(num);
        } else {
            $(".numBox").val(minusNum);
        }
    });
    //위에꺼 안될때 대비
    // function change(num) {
    //     var x = document.form;
    //     var y = Number(count.value) + num;
    //     if (y < 1)y = 1;
    //     x.count.value = y;
    // }

    //onclick alert
    $(".Dele").click(function(){
        confirm("삭제하시겠습니까?")
    });
</script>

</body>
</html>