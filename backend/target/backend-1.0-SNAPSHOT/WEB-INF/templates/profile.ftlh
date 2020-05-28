<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <title>Document</title>
</head>
<body style="margin: 0; padding: 0">
<header style=" background-color: #B03F39; font-weight: bold; font-size: 20px; color: white">
    ${user.getName()} ${user.getUsername()}
    <#if currentUser == user.getUsername()>
        <form action="#">
            <input type="submit" value="Settings">
        </form>
        <form action="/logout">
            <input type="submit" value="Logout">
        </form>
        <form action="/feed">
            <input type="submit" value="Feed">
        </form>
        <form action="/picUpload">
            <input type="submit" value="Upload Pic">
        </form>
    <#else>
        <button id="follow_btn">
            Subscribe
        </button>
        <form action="#">
            <input type="submit" value="Unsubscribe">
        </form>
    </#if>

    <div>
        <h3>Followers</h3>
        <#if user.getFollowers()??>
            <#list user.getFollowers() as follower>
                <div>
                    <a href="/profile/${follower.username}">
                        ${follower.username}
                    </a>
                </div>
            </#list>
        </#if>
    </div>
    <div>
        <h3>Followings</h3>
        <#if user.getFollowings()??>
            <#list user.getFollowings() as following>
                <div>
                    <a href="/profile/${following.username}">
                        ${following.username}
                    </a>
                </div>
            </#list>
        </#if>
    </div>
</header>
<main>
    ${springMacroRequestContext.getContextPath()}
    ${rc.getContextPath()}
    <div style="width: 80%; margin: 0 auto; background-color: antiquewhite">
        <div style="width: 530px; margin: 0 auto; padding-top: 50px;">
            <#list user.getPosts() as post>
                <div style="margin-bottom: 50px; padding: 10px; border: 2px gray solid">

                    <img style="width: 506px" src="/image/${post.getPicName()}">
                    <button span-id="${post.id}" class="like" onclick="like()">
                        Like
                    </button>
                    <span id="likeCount${post.id}">${post.getLikes()?size}</span>

                </div>
            </#list>

        </div>
    </div>

</main>


<script>

    //
    //     var el = document.getElementById("likeCount");
    //     console.log(el.getAttribute("id"));
    //     var likeCount = el.innerHTML;
    //     likeCount++;
    //     el.innerHTML = likeCount;

        $('.like').click(function () {
            var id = this.getAttribute('span-id');
            console.log(id);
            var el = document.getElementById('likeCount' + id);
            var likeCount = el.innerHTML;
            console.log(likeCount);
            el.innerHTML = ++likeCount;
            // $.ajax({
            //     type: "POST",
            //     url: "http://localhost:8080/like",
            //     data: JSON.stringify({postId: id}),
            //     dataType: "json",
            //     processData: false,
            //     contentType: "application/json"
            // })
            $.get("http://localhost:8080/like/" + id)
        })

    $('#follow_btn').click(function () {
        var username = "${user.username}"
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/follow',
            // data: JSON.stringify({id: id}),
            data: {
                username: username
            },
            // contentType: "application/json; charset=utf-8",
            // dataType: "json",
            success: function (data) {
                alert(data)
            },
            fail: function (errMsg) {
                alert(errMsg)
            }
        })
    })

</script>
</body>
</html>