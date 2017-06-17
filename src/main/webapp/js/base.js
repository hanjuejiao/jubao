


jQuery(".cont1").slide({mainCell:".hd ul",titCell:".bd li",effect:"leftLoop",autoPlay:true});

jQuery(".cont3l").slide({mainCell:".hm ul",titCell:".ht li ",effect:"left"});

$(function(){

    $(".cont3l").find(".ht li").hover(function(){
        $(this).find("p").show();
        $(this).siblings("li").find("p").hide();
    });

    //左侧导航下拉
    $(".contcentleft").find('li').click(function(){
            $(this).addClass("on").siblings().removeClass("on");
            if($(this).hasClass("on")){
                    $(this).find(".secondhide").stop().slideDown().end().siblings().find(".secondhide").stop().slideUp();
            }

    });

    //切换正文字体大小
    $(".fc").find('li').click(function(){
        if($(this).hasClass("big-font")){
            $(".text").find("p").css("font-size","20px");
        }else if($(this).hasClass("small-font")){
            $(".text").find("p").css("font-size","14px");
        }else{
            $(".text").find("p").css("font-size","16px");
        }
    })

    //弹窗1
    $(".dwbtn").click(function(){
        $("#pop1").show().find(".close").click(function(){
            $(this).parents("#pop1").hide();
        }).end().find(".bm").click(function(){
            $("#pop1").hide();
            $("#pop2").show().find(".close").click(function(){
                $(this).parents("#pop2").hide();
            });
        });
    })

})