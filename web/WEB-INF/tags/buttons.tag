<%@tag description="Buttons tag" pageEncoding="UTF-8"%>
<br/>
<div style="margin-top:40px">
    <div>
        <a class="paper-btn" href="${basePath}/triangle">Triângulos</a>
        <a class="paper-btn" href="javascript:alertYouDumb()">Não clique aqui</a>
        <a class="paper-btn" href="${basePath}/users">Usuários</a>
        <div style="padding-bottom:30px; padding-top: 70px; margin-bottom:30px">
            <a class="paper-btn" href="${basePath}">Início</a>
        </div>
    </div>
</div>
<script>
    var alertYouDumb = function () {
        return (function (msg) {
            console.error(msg);
            alert(msg);
        })('Eu falei pra não clicar, burro!');
    };
</script>
