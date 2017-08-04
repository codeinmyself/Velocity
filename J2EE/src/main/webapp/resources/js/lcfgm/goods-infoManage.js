/**
 * Created by lenovo on 2017/5/4.
 */
$(document).ready(function () {
    getAllInfo();
});

function getAllInfo() {
    var tbody=window.document.getElementById("tbody-result");
    $.ajax({
        type:'GET',
        url:'/getAllgoodsInfo',
        dataType:'json',
        success:function (data) {
            var str = "";
            $.each(data,function (i,item) {
//                $("#name").text(item.name);
                str += "<tr>" +
                    "<td>" + item.id + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td>$" + item.real_price + "</td>" +
                    "<td>" + item.stock_count + "</td>" +
                    "<td>" + item.weight + "g</td>" +
                    "<td>" + item.pre_sale_number + "</td>" +
                    /*"<td><button type=\"button\"  class=\"btn btn-default btn-xs\" data-toggle=\"modal\" data-target=\"#modifyGood\">修改</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"delete();\">删除</button> </td>"*/
                    "<td><button type=\"button\"  class=\"btn btn-default btn-xs\" onclick=\"showModify("+item.id+")\" >修改</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"deleteGood("+item.id+")\">删除</button> </td>"
                    "</tr>";
                })
            tbody.innerHTML=str;
        },
        error:function () {
            alert("error");
        }
    })
}
$('#addSubmit').click(function () {
    var new_name=$('#new_name').val();
    var new_price=$('#new_price').val();
    var new_category=$('#new_category option:selected').val();
    var new_brand=$('#new_brand option:selected').val();
    var new_stock_count=$('#new_stock_count').val();
    var new_weight=$('#new_weight').val();
    var new_package_number=$('#new_package_number').val();
    var new_divide=$('#new_divide option:selected').val();
    /*var new_divide=$('#new_divide').find('input:radio:checked').val();*/
    var new_default_express=$('#new_default_express').val();
    var dataArr={
        "name":new_name+"",
        "realPrice":new_price+"",
        "categoryId":new_category+"",
        "brandId":new_brand+"",
        "stockCount":new_stock_count+"",
        "weight":new_weight+"",
        "preSaleNumber":new_package_number+"",
        "isDividable":new_divide+"",
        "defaultExpress":new_default_express+""
    };
    alert(dataArr.isDividable+","+dataArr.categoryId+","+dataArr.brandId+","+dataArr.name);
    $.ajax({
        type:'POST',
        url:'/insertGood',
        /*contentType:'application/json;charset=utf-8',*/
        contentType:'json',
        async: false,
        data:dataArr,
        error:function(){
            alert("error");
            /*var tbody=window.document.getElementById("tbody-result");
            var str = "";
                str += "<tr>" +
                    "<td>" + dataArr.id + "</td>" +
                    "<td>" + dataArr.name + "</td>" +
                    "<td>$" + dataArr.realPrice + "</td>" +
                    "<td>" + dataArr.categoryId + "</td>" +
                    "<td>" + dataArr.brandId + "</td>" +
                    "<td>" + dataArr.stockCount + "</td>" +
                    "<td>" + dataArr.weight + "g</td>" +
                    "<td>" + dataArr.preSaleNumber + "</td>" +
                    "<td>" + dataArr.isDividable+ "</td>" +
                    "<td>" + dataArr.defaultExpress + "</td>" +
                    /!*"<td><button type=\"button\"  class=\"btn btn-default btn-xs\" data-toggle=\"modal\" data-target=\"#modifyGood\">修改</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"delete();\">删除</button> </td>"*!/
                    "<td><button type=\"button\"  class=\"btn btn-default btn-xs\" onclick=\"showModify("+dataArr.id+")\" >修改</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"deleteGood("+dataArr.id+")\">删除</button> </td>"+
                "</tr>";
            tbody.innerHTML=str;*/
        },
    })
});
/*根据id查询商品信息，显示在模态框里面*/
function showModify(id) {
    $('#modifyGood').modal();
    $.ajax({
        type:'GET',
        url:'/getGoodsById',
        dataType:'json',
        data:{
            "id":id,
        },
        success:function (data) {
            $("#name").attr("placeholder",data.name);
            $("#price").attr("placeholder",data.real_price);
            var category = document.getElementById("category");
            for(i=0;i<category.length;i++){
                if(category[i].value == data.category_id)
                    category[i].selected = true;
            }
            var brand = document.getElementById("brand");
            for(i=0;i<brand.length;i++){
                if(brand[i].value == data.brand_id)
                    brand[i].selected = true;
            }
            $("#stock_count").attr("placeholder",data.stock_count);
            $("#weight").attr("placeholder",data.weight);
            $("#package_number").attr("placeholder",data.pre_sale_number);
            var divide = document.getElementById("divide");
            for(i=0;i<divide.length;i++){
                if(divide[i].value == data.is_dividable)
                    divide[i].selected = true;
            }
            $("#default_express").attr("placeholder",data.default_express);
        },
        error:function () {
            alert("error");
        }
    })
    $('#updateSubmit').click(function (id) {
        var name=$('#name').val();
        var price=$('#price').val();
        var category=$('#category option:selected').val();
        var brand=$('#brand option:selected').val();
        var stock_count=$('#stock_count').val();
        var weight=$('#weight').val();
        var package_number=$('#package_number').val();
        var divide=$('#divide option:selected').val();
        var default_express=$('#default_express').val();
        var dataArr={
            "id":id,
            "name":name+"",
            "realPrice":price,
            "categoryId":category+"",
            "brandId":brand+"",
            "stockCount":stock_count,
            "weight":weight,
            "preSaleNumber":package_number,
            "isDividable":divide,
            "defaultExpress":default_express+""
        };
        $.ajax({
            type:'post',
            url:'/updateGood',
            async: false,
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(dataArr),
            success:function(){
            },
            error:function () {
                alert("updateerror");
            }
        })
    })
}
/*删除商品的模态框*/
function deleteGood(id)
{
    $('#deleteGood').modal();
    $('#deleteSubmit').click(function () {
        $.ajax({
            type:'GET',
            url:'/deleteGood',
            contentType:'json',
            data: {
                "id": id,
            },
            success: function () {
                alert("删除成功");
            },
            error: function () {
            }
        });
    })
}

