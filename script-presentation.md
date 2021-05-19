# Giới thiệu về lịch sử

- Javafx có tiền thân là F3 được bắt đầu bởi 1 pro tên là Chris Oliver. Sau đó được mua lại bởi sun microsystem và được đổi tên thành javafx. JavaFx cung cấp các khái niệm mạnh mẽ giúp chúng ta phát triển code trở nên dễ dàng hơn

# Điểm khác biệt giữa Swing khi so sánh với JFX (JavaFX)
Swing giống như là toolkit dành cho GUI widget. Việc chúng ta cần làm là phải phải suy nghĩ xem làm thế nào để tạo nên ngôi nhà bằng những công cự và vật liệu có sẵn (toolkit). Đối với JFX, JFX cung cấp cho chúng ta nhiều sự lựa chọn của từng thành phần trong căn nhà, và hoàn thiện nó bằng công cụ có sẵn (tránh được giai đoạn thiết kế ). JFX được xem là một platform (gần như framework)

Đọc và phân tích cái bảng

Property bindgins nghĩa là chỉ cần cập nhật giá trị của node thì visual cũng thay đổi


Một điều đặc biệt nữa là swing có rất nhiều UI component đã đươc thiết kế sẵn, tuy nhiên vẫn rất lép vê hơn khi so sánh với JFX  (lastest) vì một vài điểm sau đây: Không còn phát triển, không thân thiện với MVC (vẫn có thể tuân theo mô hình MVC nhưng chúng ta vẫn cần rất nhiều file java đảm nhiểm phần giao diện thì không hay chút nào), chậm hơn JavaFx

JavaFX hỗ trợ mạnh mẽ trong việc thiết kế và khởi tạo giao diện bằng FXML (phát triển từ fx script), hỗ trợ style CSS, 3D view và Web View cùng nhiều chức năng tương tác với Internet khác.

# Cấu trúc một app của JavaFx gồm:

Stage ⇒ Scene ⇒ scene graph (tree) ⇒ node (ui controls)

Ở mỗi một node sẽ có 3 phần chính : Giao diện (viết bằng FXML) và Controller (Java). Chúng ta có thể *gom nhóm* các node (thành phần) lại một node mới (component) để dễ dàng trong việc quản lý. Controller sẽ chịu trách nhiệm trực tiếp khi tương tác với Node đó thông qua Event. ngoài ra JavaFx còn hỗ trợ CSS (còn nhiều hạn chế)

- Tách biệt ra FXML ⇒ đổi UI thì không cần phải đổi code java như swing ⇒ dễ bảo trì và sữa lỗi
- Tích hợp thông qua Controllers
- Dễ làm quen đối với những người đã biết ứng dụng web (như mình)
- responsive bằng việc sử dụng các loại Layout
- Tích hợp CSS

Một điểm trừ của JFX là đã tách ra khỏi jdk, trở thành một third party libs (opensource) dẫn tới khả năng tiến hoá đáng kể

# Giới thiệu cách viết component search

Khi chúng ta viết component thì component sẽ hành xử như là một node, mà thành phần quan trọng nhất của Node (giao diện, cách mà nó được tạo thành thì là FXML), vậy nên cần có đoạn code khởi tạo Controller tương ứng. Một node khi khởi tạo xong sẽ gọi tới hàm initialze để hoàn thành các công viêc của chúng (đặt giá trị mặc định).


# Demo và giải thích 

