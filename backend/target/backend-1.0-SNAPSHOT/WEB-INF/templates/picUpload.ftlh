<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script>
        function sendFile() {
            let formData = new FormData();
            let files = ($('#file'))[0]['files'];
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file)
            })
            console.log(formData)

            $.ajax({
                enctype: 'multipart/form-data',
                type: "POST",
                url: "http://localhost:8080/picUpload",
                data: formData,
                processData: false,
                contentType: false
            }).done(function (response) {
                alert(response)
            }).fail(function () {
                alert('Error')
            })

        }
    </script>
</head>
<body>
    <div>
        <input type="file" id="file" name="file" placeholder="File name">
        <button onclick="sendFile()">
            Upload
        </button>

    </div>


</body>
</html>