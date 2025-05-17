package com.example.quanlydaotao.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "register";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            addCurrentUserInfo(model, authentication);
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();

            // Thêm các thuộc tính để kiểm tra role trong template
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));

            // Thêm thông tin user type
            if (role.equals("ROLE_student")) {
                model.addAttribute("userType", "Sinh viên");
            } else if (role.equals("ROLE_admin")) {
                model.addAttribute("userType", "Admin");
            } else if (role.equals("ROLE_teacher")) {
                model.addAttribute("userType", "Giảng viên");
            }
        } else {
            model.addAttribute("isLoggedIn", false);
        }
        return "home";
    }

    @GetMapping("/thongtinchung")
    @PreAuthorize("hasAnyAuthority('ROLE_student', 'ROLE_teacher', 'ROLE_admin')")
    public String thongTinChung(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "thongtinchung";
    }

    @GetMapping("/khungchuongtrinh")
    @PreAuthorize("hasAnyAuthority('ROLE_student', 'ROLE_teacher', 'ROLE_admin')")
    public String khungChuongTrinh(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "khungchuongtrinh";
    }

    @GetMapping("/hocphan")
    @PreAuthorize("hasAnyAuthority('ROLE_student', 'ROLE_teacher', 'ROLE_admin')")
    public String hocPhan(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "hocphan";
    }

    @GetMapping("/CTDT_UserViews")
    @PreAuthorize("hasAnyAuthority('ROLE_student', 'ROLE_teacher', 'ROLE_admin')")
    public String ctdtUserViews(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("userRole", role);
        }
        return "CTDT_UserViews";
    }

    @GetMapping("/decuongchitiet")
    @PreAuthorize("hasAnyAuthority('ROLE_student', 'ROLE_teacher', 'ROLE_admin')")
    public String deCuongChiTiet(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "decuongchitiet";
    }

    @GetMapping("/kehoachdayhoc")
    @PreAuthorize("hasAnyAuthority('ROLE_teacher', 'ROLE_admin', 'ROLE_student')")
    public String keHoachDayHoc(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "kehoachdayhoc";
    }

    @GetMapping("/kehoachmonhom")
    @PreAuthorize("hasAnyAuthority('ROLE_teacher', 'ROLE_admin', 'ROLE_student')")
    public String keHoachMoNhom(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("isUser", role.equals("ROLE_student"));
            model.addAttribute("userRole", role);
        }
        return "kehoachmonhom";
    }

    @GetMapping("/giangvien")
    @PreAuthorize("hasAnyAuthority('ROLE_teacher', 'ROLE_admin')")
    public String giangVien(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("userRole", role);
        }
        return "giangvien";
    }

    @GetMapping("/phanconggiangday")
    @PreAuthorize("hasAnyAuthority('ROLE_teacher', 'ROLE_admin')")
    public String phanCongGiangDay(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            model.addAttribute("isAdmin", role.equals("ROLE_admin"));
            model.addAttribute("isTeacher", role.equals("ROLE_teacher"));
            model.addAttribute("userRole", role);
        }
        return "phanconggiangday";
    }

    @GetMapping("/quanlytaikhoan")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String quanLyTaiKhoan(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            model.addAttribute("isAdmin", true);
            model.addAttribute("userRole", "ROLE_admin");
        }
        return "quanlytaikhoan";
    }

    @GetMapping("/thongke")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String thongKe(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        if (authentication != null) {
            model.addAttribute("isAdmin", authentication.getAuthorities()
                    .contains(new SimpleGrantedAuthority("ROLE_admin")));
        }
        return "thongke";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String admin(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        return "admin";
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasAuthority('ROLE_teacher')")
    public String teacher(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        return "teacher";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_student')")
    public String user(Model model, Authentication authentication) {
        addCurrentUserInfo(model, authentication);
        return "user";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }

    private void addCurrentUserInfo(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("currentUser", authentication.getName());
            model.addAttribute("isLoggedIn", true);
            
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            if (!authorities.isEmpty()) {
                String role = authorities.iterator().next().getAuthority();
                if (role.equals("ROLE_student")) {
                    model.addAttribute("userType", "Sinh viên");
                } else if (role.equals("ROLE_admin")) {
                    model.addAttribute("userType", "Admin");
                } else if (role.equals("ROLE_teacher")) {
                    model.addAttribute("userType", "Giảng viên");
                }
            }
        } else {
            model.addAttribute("isLoggedIn", false);
        }
    }
}
