﻿# QuanLyDaoTao
# QuanLyDaoTao - Hệ Thống Quản Lý Đào Tạo

## Giới thiệu
Hệ thống Quản Lý Đào Tạo là một ứng dụng web được phát triển nhằm hỗ trợ quản lý thông tin về chương trình đào tạo, học phần, giảng viên và sinh viên trong môi trường giáo dục đại học. Dự án sử dụng Spring Boot framework và các công nghệ hiện đại để xây dựng một hệ thống quản lý toàn diện.

### Các tính năng chính
- Quản lý thông tin chương trình đào tạo
- Quản lý khung chương trình
- Quản lý học phần và đề cương chi tiết
- Phân công giảng dạy
- Quản lý Giảng viên
- Quản lý thông tin cá nhân

## Công nghệ sử dụng
- **Backend**: Java 8+, Spring Boot, Spring Data JPA, Spring Security
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Database**: MySQL
- **Build tool**: Maven
- **Version Control**: Git

## Cấu trúc dự án
```
quanlydaotao/
├── src/
│   ├── main/
│   │   ├── java/com/example/quanlydaotao/
│   │   │   ├── config/         # Cấu hình ứng dụng
│   │   │   ├── controller/     # Xử lý request từ client
│   │   │   ├── model/          # Các entity và model
│   │   │   ├── repository/     # Truy vấn dữ liệu
│   │   │   ├── service/        # Logic nghiệp vụ
│   │   │   └── QuanLyDaoTaoApplication.java
│   │   └── resources/
│   │       ├── static/         # CSS, JavaScript, images
│   │       ├── templates/      # Thymeleaf templates
│   │       └── application.properties
│   └── test/                   # Unit tests
├── .mvn/                       # Maven wrapper
├── target/                     # Compiled files
├── .gitignore                  # Git ignore file
├── .gitattributes              # Git attributes
├── mvnw                        # Maven wrapper script (Unix)
├── mvnw.cmd                    # Maven wrapper script (Windows)
├── pom.xml                     # Maven dependencies
└── README.md                   # This file
```

## Các trang chính
1. **Trang chủ** (`/home`): Trang chào mừng và điều hướng
2. **Thông tin chung** (`/thongtinchung`): Quản lý thông tin chương trình đào tạo
3. **Khung chương trình** (`/khungchuongtrinh`): Quản lý khung chương trình đào tạo
4. **Học phần** (`/hocphan`): Quản lý thông tin học phần
5. **Đề cương chi tiết** (`/decuongchitiet`): Quản lý đề cương chi tiết học phần
6. **Phân công giảng dạy** (`/phanconggiangday`): Quản lý phân công giảng viên
7. **Hồ sơ cá nhân** (`/profile`): Quản lý thông tin cá nhân

## Cấu hình hệ thống
- **Database**: Cấu hình kết nối trong `src/main/resources/application.properties`
- **Security**: Cấu hình bảo mật trong `src/main/java/com/example/quanlydaotao/config/SecurityConfig.java`
- **JPA**: Cấu hình JPA trong `src/main/java/com/example/quanlydaotao/config/JpaConfig.java`
- **Thymeleaf**: Cấu hình Thymeleaf trong `src/main/java/com/example/quanlydaotao/config/ThymeleafConfig.java`

## Yêu cầu hệ thống
- JDK 8 hoặc cao hơn
- Maven 3.6 hoặc cao hơn
- MySQL 5.7 hoặc cao hơn
- Trình duyệt web hiện đại (Chrome, Firefox, Edge)

## Hướng dẫn cài đặt và sử dụng

### Chuẩn bị môi trường
1. **Cài đặt JDK (Java Development Kit)**
   - Tải và cài đặt JDK từ [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html)
   - Thiết lập biến môi trường JAVA_HOME:
     - Windows:
       ```
       setx JAVA_HOME "C:\Program Files\Java\jdk-x.x.x"
       setx PATH "%PATH%;%JAVA_HOME%\bin"
       ```
     - Linux/Mac:
       ```bash
       export JAVA_HOME=/usr/lib/jvm/java-x-openjdk
       export PATH=$PATH:$JAVA_HOME/bin
       ```
   - Kiểm tra cài đặt: `java -version`

2. **Cài đặt Maven**
   - Tải và cài đặt Maven từ [Apache Maven](https://maven.apache.org/download.cgi)
   - Thiết lập biến môi trường M2_HOME:
     - Windows:
       ```
       setx M2_HOME "C:\Program Files\apache-maven-x.x.x"
       setx PATH "%PATH%;%M2_HOME%\bin"
       ```
     - Linux/Mac:
       ```bash
       export M2_HOME=/opt/apache-maven-x.x.x
       export PATH=$PATH:$M2_HOME/bin
       ```
   - Kiểm tra cài đặt: `mvn -version`

3. **Cài đặt MySQL**
   - Tải và cài đặt MySQL từ [MySQL Downloads](https://dev.mysql.com/downloads/)
   - Cài đặt MySQL Server và MySQL Workbench
   - Tạo database "quanlydaotao":
     ```sql
     CREATE DATABASE quanlydaotao CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     ```
   - Tạo tài khoản người dùng và cấp quyền:
     ```sql
     CREATE USER 'quanlydaotao'@'localhost' IDENTIFIED BY 'password';
     GRANT ALL PRIVILEGES ON quanlydaotao.* TO 'quanlydaotao'@'localhost';
     FLUSH PRIVILEGES;
     ```

4. **Cài đặt Git**
   - Tải và cài đặt Git từ [Git SCM](https://git-scm.com/downloads)
   - Cấu hình Git:
     ```bash
     git config --global user.name "Your Name"
     git config --global user.email "your.email@example.com"
     ```

5. **Cài đặt IDE (Visual Studio Code được khuyến nghị)**
   - Tải và cài đặt Visual Studio Code từ [VS Code](https://code.visualstudio.com/)
   - Cài đặt các extension:
     - Java Extension Pack
     - Spring Boot Extension Pack
     - Thymeleaf
     - GitLens
     - Maven for Java

### Clone và cài đặt dự án
1. **Clone repository**:
   ```bash
   git clone https://github.com/your-username/quanlydaotao.git
   cd quanlydaotao
   ```

2. **Cấu hình kết nối database**:
   - Mở file `src/main/resources/application.properties`
   - Cập nhật thông tin kết nối database:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/quanlydaotao?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true
     spring.datasource.username=quanlydaotao
     spring.datasource.password=password
     ```
   - Mở Xampp tạo csdl: quanlydaotao -> tạo tài khoản để đăng nhập trong bảng taikhoan

3. **Build dự án**:
   ```bash
   ./mvnw clean install
   ```
   Hoặc sử dụng Maven trực tiếp:
   ```bash
   mvn clean install
   ```

4. **Chạy ứng dụng**:
   ```bash
   ./mvnw spring-boot:run
   ```
   Hoặc sử dụng Maven trực tiếp:
   ```bash
   mvn spring-boot:run
   ```

5. **Truy cập ứng dụng**:
   - Mở trình duyệt và truy cập: http://localhost:8080/login

### Build và triển khai ứng dụng

#### Build JAR file
1. **Build JAR file**:
   ```bash
   ./mvnw clean package
   ```
   Hoặc sử dụng Maven trực tiếp:
   ```bash
   mvn clean package
   ```
   File JAR sẽ được tạo trong thư mục `target/`.

2. **Chạy ứng dụng từ JAR file**:
   ```bash
   java -jar target/quanlydaotao-0.0.1-SNAPSHOT.jar
   ```

#### Triển khai trên server
1. **Chuẩn bị server**:
   - Cài đặt JDK 8+ trên server
   - Cài đặt MySQL trên server hoặc sử dụng dịch vụ MySQL từ xa
   - Cấu hình tường lửa để mở cổng 8080 (hoặc cổng tùy chỉnh)

2. **Tạo file cấu hình cho môi trường production**:
   - Tạo file `application-prod.properties` trong thư mục `src/main/resources/`
   - Cấu hình các thông số cho môi trường production:
     ```properties
     # Server
     server.port=8080
     
     # Database
     spring.datasource.url=jdbc:mysql://your-production-db-host:3306/quanlydaotao
     spring.datasource.username=your-production-username
     spring.datasource.password=your-production-password
     
     # Logging
     logging.level.org.springframework=ERROR
     logging.level.com.example.quanlydaotao=INFO
     
     # Security
     spring.security.user.name=admin
     spring.security.user.password=secure-password
     ```

## Hướng dẫn sử dụng

### Đăng nhập hệ thống
1. Truy cập URL: http://localhost:8080/login
2. Nhập thông tin đăng nhập:
   - Tài khoản: admin
   - Mật khẩu: admin (hoặc mật khẩu đã cấu hình)

### Quản lý chương trình đào tạo
1. Từ trang chủ, chọn "Quản lý Đào Tạo"
2. Xem danh sách các chương trình đào tạo hiện có
3. Thêm mới chương trình đào tạo:
   - Nhấn nút "Thêm mới"
   - Điền thông tin chương trình đào tạo
   - Nhấn "Lưu" để hoàn tất

### Quản lý khung chương trình
1. Từ trang chủ, chọn "Quản lý Khung Chương Trình"
2. Xem danh sách khung chương trình hiện có
3. Thêm mới khung chương trình:
   - Nhấn nút "Thêm CTKhung Mới"
   - Chọn ngành và niên khóa
   - Nhập số tín chỉ cho từng khối kiến thức
   - Nhấn "Thêm" để hoàn tất

### Quản lý học phần
1. Từ trang chủ, chọn "Quản lý Học Phần"
2. Xem danh sách học phần hiện có
3. Thêm mới học phần:
   - Nhấn nút "Thêm mới"
   - Điền thông tin học phần
   - Nhấn "Lưu" để hoàn tất

### Quản lý đề cương chi tiết
1. Từ trang chủ, chọn "Quản lý Đề Cương Chi Tiết"
2. Chọn học phần cần quản lý đề cương
3. Xem và chỉnh sửa thông tin đề cương chi tiết

### Phân công giảng dạy
1. Từ trang chủ, chọn "Phân Công Giảng Dạy"
2. Xem danh sách phân công hiện tại
3. Thêm mới phân công:
   - Nhấn nút "Thêm mới"
   - Chọn giảng viên và học phần
   - Điền thông tin phân công
   - Nhấn "Lưu" để hoàn tất

### Quản lý thông tin cá nhân
1. Từ trang chủ, chọn "Hồ sơ cá nhân"
2. Xem thông tin cá nhân
3. Chỉnh sửa thông tin:
   - Nhấn nút "Chỉnh sửa"
   - Cập nhật thông tin
   - Nhấn "Lưu" để hoàn tất

## Quản lý dữ liệu
### Chương trình đào tạo
Hệ thống quản lý các chương trình đào tạo với các thông tin:
- Tên ngành
- Mã ngành
- Niên khóa
- Thời gian đào tạo
- Số tín chỉ
- Khối kiến thức
- Ngôn ngữ lập trình (đối với ngành CNTT)
- Khoa quản lý
- Website

### Khung chương trình
Quản lý khung chương trình đào tạo với các khối kiến thức:
- Kiến thức đại cương
- Kiến thức cơ sở ngành
- Kiến thức chuyên ngành
- Thực tập và đồ án tốt nghiệp

### Phân công giảng dạy
Quản lý việc phân công giảng viên giảng dạy các học phần với thông tin:
- Mã cán bộ
- Họ tên giảng viên
- Năm sinh
- Chức danh, học vị
- Tên học phần
- Mã học phần
- Số tín chỉ
- Số tiết học phần
- Số lượng nhóm
- Học kỳ
- Tổng tiết giảng dạy
- Bộ môn

## Bảo mật
Hệ thống sử dụng Spring Security để bảo vệ các tài nguyên và phân quyền người dùng. Hiện tại, hệ thống có các vai trò:
- ADMIN: Quản trị viên hệ thống
- USER: Người dùng thông thường

## Xử lý sự cố thường gặp

### Không thể kết nối đến cơ sở dữ liệu
- Kiểm tra MySQL đã được khởi động
- Kiểm tra thông tin kết nối trong file `application.properties`
- Kiểm tra tài khoản và mật khẩu MySQL
- Kiểm tra database đã được tạo

### Ứng dụng không khởi động
- Kiểm tra logs trong thư mục `logs/` hoặc output console
- Kiểm tra cổng 8080 đã được sử dụng bởi ứng dụng khác chưa
- Kiểm tra JDK đã được cài đặt đúng cách

### Lỗi khi build dự án
- Kiểm tra Maven đã được cài đặt đúng cách
- Kiểm tra kết nối internet để tải các dependencies


