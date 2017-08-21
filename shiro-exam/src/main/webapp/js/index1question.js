/**
 * Created by yorge on 2017/7/24.
 */
$(document).ready(function (e) {
    $('#addquerstions').click(function () {

        var index = $('input:radio:checked').val(); //选择添加问题的类型

        if($(".yd_box").text() != "") {
            $(".yd_box").children().remove();
        }

        /*if ($(".yd_box").html() != null) {
            alert("asdfadsf")
            //delYuanContent();
        }*/
        var movie_box = '<div class="movie_box" style="border: 1px solid rgb(255, 255, 255);"></div>';
        var Grade = $(".yd_box").find(".movie_box").length + 1;
        switch (index) {
            case "0": //单选
            case "1": //多选
            case "2": //问答
                var wjdc_list = '<ul class="wjdc_list"></ul>'; //问答 单选 多选
                var danxuan = "";
                if (index == "0") {
                    danxuan = '【单选】';
                } else if (index == "1") {
                    danxuan = '【多选】';
                } else if (index == "2") {
                    danxuan = '【判断】'
                }
                //wjdc_list是在网页上放置试题的界面
                wjdc_list = $(wjdc_list).append(' <li><div class="tm_btitlt"><i class="nmb">' + Grade + '</i>. <i class="btwenzi">请编辑问题</i><span class="tip_wz">' + danxuan + '</span></div></li>');
                movie_box = $(movie_box).append(wjdc_list);
                movie_box = $(movie_box).append('<div class="dx_box" data-t="' + index + '"></div>');
                break;
        }

        $(movie_box).hover(function () {
            var html_cz = "<div class='kzqy_czbut'><a href='javascript:void(0)'  class='bianji'>编辑</a></div>";
            $(this).css({
                "border": "1px solid #0099ff"
            });
            $(this).children(".wjdc_list").after(html_cz);
        }, function () {
            $(this).css({
                "border": "1px solid #fff"
            });
            $(this).children(".kzqy_czbut").remove();
            //$(this).children(".dx_box").hide();
        });
        $(".yd_box").append(movie_box);

    });

    //鼠标移上去显示按钮
    $(".movie_box").hover(function () {
        var html_cz = "<div class='kzqy_czbut'><a href='javascript:void(0)'  class='bianji'>编辑</a>";
        $(this).css({
            "border": "1px solid #0099ff"
        });
        $(this).children(".wjdc_list").after(html_cz);
    }, function () {
        $(this).css({
            "border": "1px solid #fff"
        });
        $(this).children(".kzqy_czbut").remove();
        //$(this).children(".dx_box").hide();
    });

    //富文本框
    var editor;
    var editor1;
    var editor2;
    //编辑
    $(".bianji").live("click", function () {
        //编辑的时候禁止其他操作
        $(this).siblings().hide();
        //$(this).parent(".kzqy_czbut").parent(".movie_box").unbind("hover");
        var dxtm = $(".dxuan").html();
        var duoxtm = $(".duoxuan").html();
        var tktm = $(".tktm").html();
        var jztm = $(".jztm").html();
        //接受编辑内容的容器
        var dx_rq = $(this).parent(".kzqy_czbut").parent(".movie_box").find(".dx_box");
        //alert(dx_rq).html();
        var title = dx_rq.attr("data-t");
        //alert(title);

        //题目选项的个数
        var timlrxm = $(this).parent(".kzqy_czbut").parent(".movie_box").children(".wjdc_list").children("li").length;

        //单选题目
        if (title == 0) {
            dx_rq.show().html(dxtm);
            //模具题目选项的个数
            var bjxm_length = dx_rq.find(".title_itram").children(".kzjxx_iteam").length;
            /*选项的内容*/
            var dxtxx_html = dx_rq.find(".title_itram").children(".kzjxx_iteam").html();

            //添加选项题目
            for (var i_tmxx = bjxm_length; i_tmxx < timlrxm - 1; i_tmxx++) {
                dx_rq.find(".title_itram").append("<div class='kzjxx_iteam'>" + dxtxx_html + "</div>");
            }

            //赋值文本框,  获得已经在界面上的题目的内容
            //题目标题
            var texte_bt_val = $(this).parent(".kzqy_czbut").parent(".movie_box").find(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text();

            //把获取的题目放到btwen_text中，也就是编辑文本框中
            dx_rq.find(".btwen_text").val(texte_bt_val);

            //遍历题目项目的文字
            var bjjs = 0;
            $(this).parent(".kzqy_czbut").parent(".movie_box").find(".wjdc_list").children("li").each(function () {
                //可选框
                var ktksfcz = $(this).find("input").hasClass("wenb_input");
                if (ktksfcz) {
                    var jsxz_kk = $(this).index();
                    dx_rq.find(".title_itram").children(".kzjxx_iteam").eq(jsxz_kk - 1).find("label").remove();
                }
                //题目选项
                var texte_val = $(this).find("span").text();
                dx_rq.find(".title_itram").children(".kzjxx_iteam").eq(bjjs - 1).find(".input_wenbk").val(texte_val);
                bjjs++
            });

            /*富文本框*/
            editor = KindEditor.create('#editor_id1', {
                resizeType: 1,
                allowPreviewEmoticons: false,
                items: [
                    'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
            });
        }

        //多选题目
        if (title == 1) {
            dx_rq.show().html(duoxtm);
            //模具题目选项的个数
            var bjxm_length = dx_rq.find(".title_itram").children(".kzjxx_iteam").length;
            var dxtxx_html = dx_rq.find(".title_itram").children(".kzjxx_iteam").html();
            //添加选项题目
            for (var i_tmxx = bjxm_length; i_tmxx < timlrxm - 1; i_tmxx++) {
                dx_rq.find(".title_itram").append("<div class='kzjxx_iteam'>" + dxtxx_html + "</div>");
            }
            //赋值文本框
            //题目标题
            var texte_bt_val = $(this).parent(".kzqy_czbut").parent(".movie_box").find(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text();
            dx_rq.find(".btwen_text").val(texte_bt_val);

            //遍历题目项目的文字
            var bjjs = 0;
            $(this).parent(".kzqy_czbut").parent(".movie_box").find(".wjdc_list").children("li").each(function () {
                //可选框框
                var ktksfcz = $(this).find("input").hasClass("wenb_input");
                if (ktksfcz) {
                    var jsxz_kk = $(this).index();
                    dx_rq.find(".title_itram").children(".kzjxx_iteam").eq(jsxz_kk - 1).find("label").remove();
                }
                //题目选项
                var texte_val = $(this).find("span").text();
                dx_rq.find(".title_itram").children(".kzjxx_iteam").eq(bjjs - 1).find(".input_wenbk").val(texte_val);
                bjjs++
            });

            /*富文本框*/
            editor1 = KindEditor.create('#editor_id2', {
                resizeType: 1,
                allowPreviewEmoticons: false,
                allowImageUpload: false,
                items: [
                    'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
            });
        }

        //填空题目
        if (title == 2) {
            dx_rq.show().html(tktm);
            //赋值文本框
            //题目标题
            var texte_bt_val = $(this).parent(".kzqy_czbut").parent(".movie_box").find(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text();
            dx_rq.find(".btwen_text").val(texte_bt_val);

            /*富文本框*/
            editor2 = KindEditor.create('#editor_id3', {
                themeType : 'simple',
                resizeType: 1,
                allowPreviewEmoticons: false,
                allowImageUpload: false,
                items: [
                    'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
            });
        }
    });

    //增加选项
    $(".zjxx").live("click", function () {
        var zjxx_html = $(this).prev(".title_itram").children(".kzjxx_iteam").html();
        $(this).prev(".title_itram").append("<div class='kzjxx_iteam'>" + zjxx_html + "</div>");
    });

    //删除一行
    $(".del_xm").live("click", function () {
        //获取编辑题目的个数
        var zuxxs_num = $(this).parent(".kzjxx_iteam").parent(".title_itram").children(".kzjxx_iteam").length;
        if (zuxxs_num > 1) {
            $(this).parent(".kzjxx_iteam").remove();
        } else {
            alert("手下留情");
        }
    });
    //取消编辑
    $(".dx_box .qxbj_but").live("click", function () {
        $(this).parent(".bjqxwc_box").parent(".dx_box").empty().hide();
        $(".movie_box").css({
            "border": "1px solid #fff"
        });
        $(".kzqy_czbut").remove();
        //
    });
    // body...
    //完成编辑（编辑）
    $(".swcbj_but").live("click", function () {

        var jcxxxx = $(this).parent(".bjqxwc_box").parent(".dx_box"); //编辑题目区
        var querstionType = jcxxxx.attr("data-t"); //获取题目类型

        switch (querstionType) {
            case "0": //单选
                //编辑题目选项的个数
                var bjtm_xm_length = jcxxxx.find(".title_itram").children(".kzjxx_iteam").length; //编辑选项的 选项个数
                var xmtit_length = jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").length - 1; //题目选择的个数

                //赋值文本框,获取html标签中的题目内容
                //题目标题
                //var texte_bt_val_bj = jcxxxx.find(".btwen_text").val(); //获取问题题目
                var el_texte_bt_val_bj = $("#editor_id1").text();

                /*
                要在这里获取编辑后的文本内容
                 */
                editor.sync();
                var html=$('#editor_id1').val();//原生API
                //将修改过的问题题目展示
                var eltexte_bt_val_bj = jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text(html);

                //删除选项
                for (var toljs = xmtit_length; toljs > 0; toljs--) {
                    jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(toljs).remove();
                }

                //遍历题目项目的文字
                var bjjs_bj = 0;
                jcxxxx.children(".title_itram").children(".kzjxx_iteam").each(function () {
                    //题目选项
                    var texte_val_bj = $(this).find(".input_wenbk").val(); //获取填写信息

                    var inputType = 'radio';
                    //jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(bjjs_bj + 1).find("span").text(texte_val_bj);
                    if (querstionType == "1") {
                        inputType = 'checkbox';
                    }
                    var li = '<li><label><input name="a" type="' + inputType + '" value=""><span>' + texte_val_bj + '</span></label></li>';
                    jcxxxx.parent(".movie_box").children(".wjdc_list").append(li);

                    bjjs_bj++
                    //可填空
                    var kxtk_yf = $(this).find(".fxk").is(':checked');
                    if (kxtk_yf) {
                        //第几个被勾选
                        var jsxz = $(this).index();
                        //alert(jsxz);
                        jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(jsxz + 1).find("span").after("<input name='' type='text' class='wenb_input'>");
                    }
                });

                break;

            case "1": //多选
                //编辑题目选项的个数
                var bjtm_xm_length = jcxxxx.find(".title_itram").children(".kzjxx_iteam").length; //编辑选项的 选项个数
                var xmtit_length = jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").length - 1; //题目选择的个数

                //赋值文本框,获取html标签中的题目内容
                //题目标题
                //var texte_bt_val_bj = jcxxxx.find(".btwen_text").val(); //获取问题题目
                var el_texte_bt_val_bj = $("#editor_id2").text();

                /*
                 要在这里获取编辑后的文本内容
                 */
                editor1.sync();
                var html=$('#editor_id2').val(); //原生API
                //将修改过的问题题目展示
                var eltexte_bt_val_bj = jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text(html);

                //删除选项
                for (var toljs = xmtit_length; toljs > 0; toljs--) {
                    jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(toljs).remove();
                }

                //遍历题目项目的文字
                var bjjs_bj = 0;
                jcxxxx.children(".title_itram").children(".kzjxx_iteam").each(function () {
                    //题目选项
                    var texte_val_bj = $(this).find(".input_wenbk").val(); //获取填写信息

                    var inputType = 'radio';
                    //jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(bjjs_bj + 1).find("span").text(texte_val_bj);
                    if (querstionType == "1") {
                        inputType = 'checkbox';
                    }
                    var li = '<li><label><input name="a" type="' + inputType + '" value=""><span>' + texte_val_bj + '</span></label></li>';
                    jcxxxx.parent(".movie_box").children(".wjdc_list").append(li);

                    bjjs_bj++
                    //可填空
                    var kxtk_yf = $(this).find(".fxk").is(':checked');
                    if (kxtk_yf) {
                        //第几个被勾选
                        var jsxz = $(this).index();
                        //alert(jsxz);
                        jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(jsxz + 1).find("span").after("<input name='' type='text' class='wenb_input'>");
                    }
                });

                break;
            case "2"://判断

                //赋值文本框,获取html标签中的题目内容
                //题目标题
                //var texte_bt_val_bj = jcxxxx.find(".btwen_text").val(); //获取问题题目
                var el_texte_bt_val_bj = $("#editor_id3").text();

                /*
                 要在这里获取编辑后的文本内容
                 */
                editor2.sync();
                var html=$('#editor_id3').val();//原生API
                //将修改过的问题题目展示,从编辑框转移到界面
                var eltexte_bt_val_bj = jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text(html);


               /* //遍历题目项目的文字
                var bjjs_bj = 0;
                jcxxxx.children(".title_itram").children(".kzjxx_iteam").each(function () {
                    //题目选项
                    var texte_val_bj = $(this).find(".input_wenbk").val(); //获取填写信息

                    var inputType = 'radio';
                    //jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(bjjs_bj + 1).find("span").text(texte_val_bj);
                    if (querstionType == "1") {
                        inputType = 'checkbox';
                    }
                    var li = '<li><label><input name="a" type="' + inputType + '" value=""><span>' + texte_val_bj + '</span></label></li>';
                    jcxxxx.parent(".movie_box").children(".wjdc_list").append(li);

                    bjjs_bj++
                    //可填空
                    var kxtk_yf = $(this).find(".fxk").is(':checked');
                    if (kxtk_yf) {
                        //第几个被勾选
                        var jsxz = $(this).index();
                        //alert(jsxz);
                        jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(jsxz + 1).find("span").after("<input name='' type='text' class='wenb_input'>");
                    }
                });*/

                jcxxxx.parent(".movie_box").children(".wjdc_list").children("li").eq(0).find(".tm_btitlt").children(".btwenzi").text(eltexte_bt_val_bj); //将修改过的问题题目展示
                break;
        }
        //清除
        $(this).parent(".bjqxwc_box").parent(".dx_box").empty().hide();

        /*删除原有内容的函数*/
        function delYuanContent(){
            var czxx = $(this).parent(".kzqy_czbut").parent(".movie_box");
            var zgtitle_gs = czxx.parent(".yd_box").find(".movie_box").length;
            var xh_num = 1;
            //重新编号
            czxx.parent(".yd_box").find(".movie_box").each(function () {
                $(".yd_box").children(".movie_box").eq(xh_num).find(".nmb").text(xh_num);
                xh_num++;
                //alert(xh_num);
            });
            czxx.remove();
        };
    });

    /*单选题富文本*/
    /*function fuwenbenBox() {

        var editor = KindEditor.create('#editor_id1', {
            resizeType: 1,
            allowPreviewEmoticons: false,
            allowImageUpload: false,
            items: [
                'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
        });

        editor.sync();
        var html=$('#editor_id1').val();//原生API
        alert(html)
        //$("#schtmlnr").val(html);//把KindEditor产生的html代码放到schtmlnr里面，用于提交
    }*/

    /*多选题富文本*/
/*
    function fuwenbenBox2() {
        editor = KindEditor.create('#editor_id2', {
            resizeType: 1,
            allowPreviewEmoticons: false,
            allowImageUpload: false,
            items: [
                'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
        });
        // 取得HTML内容
        var htmlssss = editor.html();

        //同步数据后可以直接取得textarea的value
        //editor.sync();
        //htmlssss = $('#editor_id').val(); // jQuery
        //设置HTML内容
        editor.html('HTML内容');
    }

    /!*判断题富文本*!/
    function fuwenbenBox3() {
        KindEditor.create('#editor_id3', {
            resizeType: 1,
            allowPreviewEmoticons: false,
            allowImageUpload: false,
            items: [
                'table', '|', 'fontsize', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', '|', 'image']
        });

        // 取得HTML内容
        var html = editor.html();

        // 同步数据后可以直接取得textarea的value
        editor.sync();
        var html3 = $('#editor_id').val(); // jQuery
        // 设置HTML内容
        editor.html('HTML内容');
    }
*/


});

