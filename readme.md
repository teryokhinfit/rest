4. Теперь, когда весь код у вас готов, то вам необходимо написать обработчики ошибок, которые выкидывает сервис `AuthorizationService`. Требования к ним такие:
    - На `InvalidCredentials` он должен обратно клиенту отсылать http статус с кодом 400 и телом в виде сообщения из exception'а
    - На `UnauthorizedUser` он должен обратно клиенту отсылать http статус с кодом 401 и телом в виде сообщения из exception'а и писать в консоль сообщение из exception'а