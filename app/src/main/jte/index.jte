<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vabalas</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
</header>

<div class="container">
    @for(int i = 1; i <= 200; i++)
        <div class="rectangle">Rectangle ${i}</div>
    @endfor
</div>

</body>
</html>
