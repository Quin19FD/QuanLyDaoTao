async function login(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const messageDiv = document.getElementById("login-message");
    messageDiv.style.color = "red"; // Mặc định là thông báo lỗi

    try {
        const response = await fetch("/api/taikhoan/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ userName: username, password: password })
        });

        if (response.ok) {
            const data = await response.json();
            messageDiv.style.color = "green";
            messageDiv.textContent = "Đăng nhập thành công! Chào " + data.tenUser;

            // ➤ Ví dụ: chuyển hướng sau 1 giây
            setTimeout(() => {
                window.location.href = "/trang-chu.html"; // hoặc trang chính của bạn
            }, 1000);
        } else {
            const errorText = await response.text();
            messageDiv.textContent = errorText || "Đăng nhập thất bại!";
        }
    } catch (error) {
        messageDiv.textContent = "Lỗi khi kết nối máy chủ!";
    }
}