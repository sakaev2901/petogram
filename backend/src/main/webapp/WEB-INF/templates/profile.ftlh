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
<body>
<main style="width: 400px; margin: 0 auto">
                 <#list posts as post>
                          <div style="margin: 50px 0">
                                      <img style="width: 400px" src="/img/${post.getPicName()}">
                                        <button span-id="likeCount${post.id}" class="like" onclick="like()">
                                            Like
                                        </button>
                                        <span id="likeCount${post.id}">5</span>

                              </div>
                         </#list>

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
            var el = document.getElementById(id)
            var likeCount = el.innerHTML;
            console.log(likeCount)
            el.innerHTML = ++likeCount;
        })
    
</script>
</body>
</html>