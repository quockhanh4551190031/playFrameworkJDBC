# Luồng hoạt động cơ bản của APP:

## Bắt đầu chạy app: 

- Khi chạy chương trình, chương trình sẽ chạy phương thức HomeController.index() đầu tiên (được định nghĩa là GET/  controllers.HomeController.index(request: Request) trong file routes vì thế sẽ chạy đường dẫn này đầu tiên)
- Khi đó chương trình sẽ xem trong session có tài khoản nào đăng nhập hay không
- Nếu không thì sẽ điều hướng đến trang đăng nhập (GET  /login  controllers.HomeController.login(request: Request))
- Nếu có thì điều hướng thẳng đến trang index
  
## Đăng nhập:

- Khi này bạn bắt đầu nhập tài khoản để đăng nhập nếu chưa có tài khoản trong session
- Bao gồm tên tài khoản, mật khẩu. Nếu sai cả hai sẽ báo lỗi "Invalid Credentials"
- Khi đã nhập đúng tài khoản, điều hướng đến trang chủ (index)

## Đăng ký:

- Nếu người dùng chưa có tài khoản, sẽ bấm nút đăng ký ở trang đăng nhập
- Sau đó nhập tên tài khoản (username) và mật khẩu (password)
- Nếu nhập tài khoản đã có trong DB thì sẽ báo lỗi "Username already existed"
- Nếu đã nhập hết username và password, tài khoản sẽ được tạo và lưu vào database với role mặc định là 'USER'
- Sau khi đã đăng ký, tự động chuyển hướng đến trang đăng nhập (login)

## Đăng xuất:

- Khi người dùng nhấn Đăng xuất, chương trình sẽ đơn giản là tạo đơn giản là tạo một session mới.

## Phân quyền (AuthController):

- public CompletionStage<Result> register(Http.Request request):
    - Phương thức này chịu trách nhiệm cho việc xử lý việc đăng ký như báo lỗi, kiểm tra xem có user nào tồn tại hay chưa

- public CompletionStage<Result> login(Http.Request request):
    - Phương thức này chịu trách nhiệm cho việc xử lý việc đăng nhập như báo lỗi khi điền thông tin sai
