$(function () {

    function yu(n) {
        return (n % 2);
    }

    function old() {
        $('#rl').empty();
        $('#rl').append('<span id="msgs" style="position: absolute;' +
            'display: none;width: 60px;z-index: 3"></span>');
        for (let i = 0; i < 7; i++) {
            for (let j = 0; j < 7; j++) {
                let a = i + "" + j;
                $('#rl').append('<div id="drl' + a + '" style="position: absolute;' +
                    'left: ' + (j * 50) + 'px;top: ' + (i * 50) + 'px;"></div>');
                let drli = $('#drl' + a);
                if(i > 0){
                    drli.attr("name",'drli');
                    if((yu(i) + yu(j)) == 1){
                        drli.css("background",'white');
                    }
                    if((yu(i) + yu(j)) == 2 || (yu(i) + yu(j)) == 0){
                        drli.css("background",'silver');
                    }
                }
                if(i == 0){
                    switch (j) {
                        case 0:
                            drli.text("日");
                            break;
                        case 1:
                            drli.text("一");
                            break;
                        case 2:
                            drli.text("二");
                            break;
                        case 3:
                            drli.text("三");
                            break;
                        case 4:
                            drli.text("四");
                            break;
                        case 5:
                            drli.text("五");
                            break;
                        case 6:
                            drli.text("六");
                            break;
                    }
                }

            }

        }
    }

    updateDate();

    function updateDate() {
        let date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth()+1;
        // let month = 5;
        let day = date.getDate();
        if(month < 10){
            month = '0' + month;
        }
        if(day < 10){
            day = '0' + day;
        }
        let mindate = year + '-' + month + '-' + day;
        let maxdate = year + '-12-31';
        $('#datebox').attr("min",mindate);
        $('#datebox').attr("max",maxdate);
        $('#year').val(year);
        $('#month').val(month);

    }

    function see(n){
        $('#box').css('display','block');
        for(let i=0;i<5;i++){
            if(i == n){
                $('#box_' + i).css('display','block');
            }else {
                $('#box_' + i).css('display','none');
            }
        }
    }

    $('#selectInformation').click(function () {
        see(0);
        let ifmt = $('#information');
        ifmt.empty();
        $.post({
            url:"/selectMyInformation",
            success:function (data) {
                ifmt.append('<tr><td>我的信息</td><td></td></tr>');
                ifmt.append('<tr><td>工号</td><td>' + data.empno + '</td></tr>');
                ifmt.append('<tr><td>姓名</td><td>' + data.ename + '</td></tr>');
                ifmt.append('<tr><td>性别</td><td>' + data.sex + '</td></tr>');
                ifmt.append('<tr><td>工作</td><td>' + data.job + '</td></tr>');
                ifmt.append('<tr><td>入职时间</td><td>' + data.hiredate + '</td></tr>');
                ifmt.append('<tr><td>所在部门号</td><td>' + data.deptno + '</td></tr>');
                ifmt.append('<tr><td>薪资</td><td>' + data.sal + '</td></tr>');
                ifmt.append('<tr><td>奖金</td><td>' + data.comm + '</td></tr>');
                $('#deptnobox').val(data.deptno);
                ale();
            }
        })
    })

    function ale(){
        let deptno = $('#deptnobox').val();
        let md = $('#myDept');
        let mm = $('#myMaster');
        md.empty();
        mm.empty();
        $.post({
            url:"/selectMyDept",
            data:{"deptno":deptno},
            success:function (data) {
                md.append('<tr><td>所在部门信息:</td></tr>');
                md.append('<tr><td>' + data.deptno + '</td></tr>');
                md.append('<tr><td>' + data.dname + '</td></tr>');
                md.append('<tr><td>部门联系方式:</td></tr>');
                md.append('<tr><td>' + data.telephone + '</td></tr>');
            }
        })
        $.post({
            url:"/selectMyMaster",
            data:{"deptno":deptno},
            success:function (data) {
                mm.append('<tr><td>直系上司：</td></tr>');
                mm.append('<tr><td>' + data.empno + '</td></tr>');
                mm.append('<tr><td>' + data.ename + '</td></tr>');
                mm.append('<tr><td>' + data.sex + '</td></tr>');
                mm.append('<tr><td>' + data.job + '</td></tr>');
            }
        })
    }

    $('#leave').click(function () {
        see(1);
        $.ajax({
            url: "/addAFL",
            success:function (data) {
                $('#empnobox_1').val(data.applicantempno);
                $('#reasonbox').val("");
                $('#empnobox_2').val(data.approverempno);
                $('#timebox').val(data.leavetime);
                $('#datebox').val("");
                $('#datesbox option:first').prop("selected",'selected');
                $('#statebox').val(data.state);
            }
        })
    })

    $('#correct').click(function () {
        see(2);
        $('#cleaves').empty();
        $.post({
            url: "/dApplicationForLeave",
            data: {"state": 0},
            success: function (data) {
                for (let i = 0; i < data.length; i++) {
                    $('#cleaves').append('<tr>' +
                        '<td>' + data[i].applicantempno + '</td>' +
                        '<td>' + data[i].reason + '</td>' +
                        '<td>' + data[i].approverempno + '</td>' +
                        '<td>' + data[i].leavetime + '</td>' +
                        '<td>' + data[i].leavedate + '</td>' +
                        '<td>' + data[i].leavedates + '</td>' +
                        '<td>' + data[i].type + '</td>' +
                        '<td>审批中...</td>' +
                        '<td><input type="button" id="yes' + i + '" value="通过"></input>' +
                        '<input type="button" id="no' + i + '" value="驳回"></input></td>' +
                        '</tr>');
                    getter(i,data[i].id);
                }
            }
        })
    })

    function getter(n,yid) {
        $('#yes' + n).click(function () {
            let id = yid;
            updatestate(id,1);
        })
        $('#no' + n).click(function () {
            let id = yid;
            updatestate(id,-1);
        })
    }

    function updatestate(id,state) {
        $.post({
            url:"/updatestate",
            data:{"id":id,"state":state},
            success:function (data) {
                if(data==1){
                    $('#correct').click();
                    alert("修改成昆！！！");
                }else {
                    alert("aaaaa");
                }
            }
        })
    }

    $('#insert').click(function () {

        if($('#reasonbox').val()==""||$('#datebox').val()==""){
            alert("请把信息填写完整");
        }else {
            let applicantempno = $('#empnobox_1').val();
            let reason = $('#reasonbox').val();
            let approverempno = $('#empnobox_2').val();
            let leavetime = $('#timebox').val();
            let leavedate = $('#datebox').val();
            let leavedates = $('#datesbox').val();
            let approvaltime = $('#approvaltime').val();
            let state = $('#statebox').val();
            let type = $('#type').val();
            $.post({
                url:"/insert",
                data:{"applicantempno":applicantempno,
                    "reason":reason,"approverempno":approverempno,
                    "leavetime":leavetime,"leavedate":leavedate,
                    "leavedates":leavedates,"approvaltime":approvaltime,
                    "state":state,"type":type},
                success:function (data) {
                    if(data==1){
                        alert("成昆！！！");
                        $('#afterleave').click();
                    }else {
                        alert("失败！！！");
                    }
                }
            })
        }

    })

    $('#afterleave').click(function () {
        see(3);
        if ($('#power').text() == "A"){
            $('#leaves').empty();
            $.post({
                url:"/selectMyApplicationForLeave",
                success:function (data) {
                    for (let i = 0; i < data.length; i++) {
                        $('#leaves').append('<tr id="albox' + i + '">' +
                            '<td style="display: none" id="idbox' + i + '">' + data[i].id + '</td>' +
                            '<td>' + data[i].applicantempno + '</td>' +
                            '<td>' + data[i].reason + '</td>' +
                            '<td>' + data[i].approverempno + '</td>' +
                            '<td>' + data[i].leavetime + '</td>' +
                            '<td>' + data[i].leavedate + '</td>' +
                            '<td>' + data[i].leavedates + '</td>' +
                            '<td>' + data[i].type + '</td>' +
                            '</tr>');
                        if(data[i].state == 0){
                            $('#albox' + i).append('<td></td>');
                            $('#albox' + i).append('<td>审批中...</td>');
                            $('#albox' + i).append('<td><input id="delete' + i + '" type="button" value="取消"></td>');
                        }
                        if(data[i].state == 1){
                            $('#albox' + i).append('<td>' + data[i].approvaltime + '</td>');
                            $('#albox' + i).append('<td>同意请假！</td>');
                            $('#albox' + i).append('<td></td>');
                        }
                        if (data[i].state == -1){
                            $('#albox' + i).append('<td>' + data[i].approvaltime + '</td>');
                            $('#albox' + i).append('<td>未通过！</td>');
                            $('#albox' + i).append('<td></td>');
                        }
                        dbox(i);
                    }
                }
            })
        }
        if ($('#power').text() == "B"){
            let les = $('#leavess');
            let empno = $('#empno').text();
            les.empty();
            $.post({
                url:"selectAfterLeaves",
                data:{"empno":empno},
                success:function (data) {
                    for (let i = 0; i < data.length; i++) {
                        les.append('<tr>' +
                            '<td>' + data[i].applicantempno + '</td>' +
                            '<td>' + data[i].reason + '</td>' +
                            '<td>' + data[i].approverempno + '</td>' +
                            '<td>' + data[i].leavetime + '</td>' +
                            '<td>' + data[i].leavedate + '</td>' +
                            '<td>' + data[i].leavedates + '</td>' +
                            '<td>' + data[i].approvaltime + '</td>' +
                            '<td>' + data[i].type + '</td>' +
                            '<td id="al' + i + '"></td>' +
                            '</tr>');
                        if(data[i].state == 1){
                            $('#al' + i).text("通过！");
                        }
                        if(data[i].state == -1){
                            $('#al' + i).text("未通过！");
                        }
                    }
                }
            })
        }
    })

    function toDays(m,n) {
        let a = 0;
        for (let i = 0; i < 7; i++) {
            for (let j = 0; j < 7; j++) {
                let b = i + "" + j;
                if(a < n && i > 0){
                    if(!(i ==  1 && j < m)){
                        a++;
                        $('#drl' + b).text(a);
                    }
                }
            }
        }
    }

    function toMonth(){
        $('div[name="drli"]').text("");
        let year = $('#year').val();
        let month = $('#month').val();
        let datee = year + "-" + month + "-01";
        let ddate = new Date(datee);
        let n = new Date(year,month,0).getDate();
        switch (ddate.getDay()) {
            case 0:
                toDays(0,n);
                break;
            case 1:
                toDays(1,n);
                break;
            case 2:
                toDays(2,n);
                break;
            case 3:
                toDays(3,n);
                break;
            case 4:
                toDays(4,n);
                break;
            case 5:
                toDays(5,n);
                break;
            case 6:
                toDays(6,n);
                break;
        }
    }

    $('#pholidays').click(function () {
        old();
        see(4);
        let year = $('#year').val();
        let month = $('#month').val();
        toMonth();
        $.post({
            url:"selectPHolidays",
            data:{"year":year,"month":month},
            success:function (data) {
                let datee = year + "-" + month + "-01";
                let ddate = new Date(datee);
                for (let i = 0; i < data.length; i++) {
                    for (let j = 0; j < data[i].days; j++) {
                        let k = ddate.getDay() + data[i].day + j - 1;
                        $('div[name="drli"]').eq(k).css("background",'yellow');
                        $('div[name="drli"]').eq(k).mouseover(function () {
                            $('#msgs').text(data[i].phname);
                            $('div[name="drli"]').eq(k).mousemove(function (e) {
                                let X = e.pageX;
                                let Y = e.pageY;
                                $('#msgs').css("left",X-580);
                                $('#msgs').css("top",Y-190);
                            })
                            $('#msgs').css("display",'block');
                        });
                        $('div[name="drli"]').eq(k).mouseleave(function () {
                            $('#msgs').css("display",'none');
                        });
                    }
                }
            }
        });
    })

    $('#jian').click(function () {
        let year = $('#year').val();
        let month = $('#month').val();
        if (month == 1){
            $('#month').val(12);
            $('#year').val(year - 1);
        }else {
            $('#month').val(month - 1);
        }
        $('#pholidays').click();
        toMonth();
    });

    $('#jia').click(function () {
        let year = $('#year').val();
        let month = $('#month').val();
        if (month == 12){
            $('#month').val(1);
            $('#year').val(parseInt(year) + 1);
        }else {
            $('#month').val(parseInt(month) + 1);
        }
        $('#pholidays').click();
        toMonth();
    });

    $('#close').click(function () {
        $('#box').css('display','none');
    })

    function dbox(n) {

        $('#delete' + n).click(function () {
            let id = $('#idbox' + n).text();
            $.post({
                url:"/deleteMyAFL",
                data:{"id":id},
                success:function (data) {
                    if(data == 1){
                        alert("取消成昆！！！");
                        $('#afterleave').click();
                    }else {
                        alert("取消失败！！！");
                    }
                }
            })
        });

    }
    
    function check(d,l,t) {
        // alert(l + " " + t);
        if(l > 500 || t > 500){
            alert("fuck");
            return;
        }
        if(250 <= l && l < 500 && t < 250){
            let x = l - 250;
            let y = 250 - t;
            y = y - 1;
            x = Math.sqrt((250 * 250 - y * y));
            let left = 250 + x + "px";
            let top = 250 - y + "px";
            d.css("margin-left",left);
            d.css("margin-top",top);
            return;
        }
        if (250 < l && l <= 500 && 250 <= t && t < 500){
            let x = l - 250;
            let y = 250 - t;
            y = y - 1;
            x = Math.sqrt((250 * 250 - y * y));
            let left = 250 + x + "px";
            let top = 250 - y + "px";
            // alert(2);
            d.css("margin-left",left);
            d.css("margin-top",top);
            return;
        }
        if (l <= 250 && 250 < t && t <= 500){
            let x = l - 250;
            let y = 250 - t;
            y = y + 1;
            x = Math.sqrt((250 * 250 - y * y));
            let left = 250 - x + "px";
            let top = 250 - y + "px";
            // alert(3);
            d.css("margin-left",left);
            d.css("margin-top",top);
            return;
        }
        if (l <= 250 && t <= 250){
            let x = l - 250;
            let y = 250 - t;
            y = y + 1;
            x = Math.sqrt((250 * 250 - y * y));
            let left = 250 - x + "px";
            let top = 250 - y + "px";
            d.css("margin-left",left);
            d.css("margin-top",top);
            return;
        }
    }
    
    function run(){
        check($('#selectInformation'),
            parseInt($('#selectInformation').css("margin-left")),
            parseInt($('#selectInformation').css("margin-top")));
        check($('#leave'),
            parseInt($('#leave').css("margin-left")),
            parseInt($('#leave').css("margin-top")));
        check($('#correct'),
            parseInt($('#correct').css("margin-left")),
            parseInt($('#correct').css("margin-top")));
        check($('#afterleave'),
            parseInt($('#afterleave').css("margin-left")),
            parseInt($('#afterleave').css("margin-top")));
        check($('#pholidays'),
            parseInt($('#pholidays').css("margin-left")),
            parseInt($('#pholidays').css("margin-top")));
    }

    let runing = setInterval(run,10);

    $('[name="doit"]').mouseover(function () {
        clearInterval(runing);
    })

    $('[name="doit"]').mouseleave(function () {
        runing = setInterval(run,10);
    })

    $('#goPH').click(function () {
        if ($('#dateboxs').val() != '' && $('#phname').val() != ''){
            let phname = $('#phname').val();
            let year = $('#dateboxs').val().substring(0,4);
            let month = parseInt($('#dateboxs').val().substring(5,7));
            let day = parseInt($('#dateboxs').val().substring(8,10));
            let days = $('#dad option:selected').val();
            $.post({
                url:"insertPH",
                data:{"year":year,"month":month,"day":day,
                    "days":days,"phname":phname},
                success:function (data) {
                    if(1 == data){
                        alert("添加成昆！！！");
                        $('#phname').val('');
                        $('#dateboxs').val('');
                        $('#pholidays').click();
                    }else {
                        alert("添加失败！！！");
                    }
                }
            });
        }else {
            alert("请把信息填写完整！！！");
        }
    });

    // $('#datebox').change(function () {
    //     alert($('#datebox').val());
    // })

    // $('#datesbox').change(function () {
    //     alert($('#datesbox').val());
    // })

})