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
<header style="height: 80px; background-color: #B03F39; font-weight: bold; font-size: 20px; color: white">

</header>
<main>
    <div style="width: 80%; margin: 0 auto; background-color: antiquewhite">
        <div style="width: 530px; margin: 0 auto; padding-top: 50px;">
            <#list posts as post>
                <div style="margin-bottom: 50px; padding: 10px; border: 2px gray solid">
                    <img style="width: 506px" src="/img/${post.getPicName()}">
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
            var id = this.getAttribute('span-id')
            console.log(id)
            var el = document.getElementById('likeCount' + id)
            var likeCount = el.innerHTML;
            console.log(likeCount)
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

</script>
</body>
</html>