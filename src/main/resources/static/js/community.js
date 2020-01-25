function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment-content").val();

    if (!content){
        alert('不能回复空内容');
        return;
    }
    $.ajax({
        url:'/comment',
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (result) {
            if (result.code == 200){
                window.location.reload();
            }else {
                if (result.code == 2003){
                    var isAccepted = confirm(result.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=5abccfd3ce255ff8a407&redirect_uri=http://localhost:8887/callback&scope=user&state=1")
                        window.localStorage.setItem("closable", true);
                    }
                }else {
                    alert(result.message);
                }
            }
            console.log(result);
        },
        dataType: "json"
    });
}