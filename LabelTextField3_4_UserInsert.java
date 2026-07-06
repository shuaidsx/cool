package day1;
//3. 라벨과 텍스트 필드 (JLabel + JTextField) + 회원가입 폼 (10개 필드)
//3. 标签和文本字段 (JLabel + JTextField) + 注册表单 (10个字段)

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LabelTextField3_4_UserInsert {
    public static void main(String[] args) {
        // 메인 프레임 생성 (회원가입 창)
        // 创建主框架 (注册窗口)
        JFrame frame = new JFrame("회원가입");
        
        // 패널 생성 - GridLayout 사용 (11행 2열)
        // 创建面板 - 使用 GridLayout (11行 2列)
        // 10개 필드 + 버튼 1개 = 11행
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 5));
        // GridLayout(rows, cols, hgap, vgap)
        // rows=11 (라벨+입력창 10쌍 + 버튼 1개)
        // cols=2 (라벨 열, 입력창 열)
        // hgap=10 (가로 간격), vgap=5 (세로 간격)
        
        // ----- 1. 아이디 입력 -----
        // ----- 1. 用户名输入 -----
        panel.add(new JLabel("아이디:"));                    // 아이디 라벨
        JTextField idField = new JTextField(15);            // 아이디 입력창
        panel.add(idField);
        
        // ----- 2. 비밀번호 입력 -----
        // ----- 2. 密码输入 -----
        panel.add(new JLabel("비밀번호:"));                  // 비밀번호 라벨
        JPasswordField passwordField = new JPasswordField(15); // 비밀번호 입력창 (● 표시)
        panel.add(passwordField);
        
        // ----- 3. 비밀번호 확인 입력 -----
        // ----- 3. 确认密码输入 -----
        panel.add(new JLabel("비밀번호 확인:"));              // 비밀번호 확인 라벨
        JPasswordField confirmPasswordField = new JPasswordField(15); // 비밀번호 확인 입력창
        panel.add(confirmPasswordField);
        
        // ----- 4. 이름 입력 -----
        // ----- 4. 姓名输入 -----
        panel.add(new JLabel("이름:"));                      // 이름 라벨
        JTextField nameField = new JTextField(15);          // 이름 입력창
        panel.add(nameField);
        
        // ----- 5. 생년월일 입력 -----
        // ----- 5. 出生日期输入 -----
        panel.add(new JLabel("생년월일 (YYYY-MM-DD):"));     // 생년월일 라벨
        JTextField birthField = new JTextField(15);         // 생년월일 입력창
        birthField.setToolTipText("예: 1990-01-01");        // 툴팁 표시
        panel.add(birthField);
        
        // ----- 6. 성별 입력 (콤보박스 사용) -----
        // ----- 6. 性别输入 (使用下拉列表) -----
        panel.add(new JLabel("성별:"));                      // 성별 라벨
        String[] genders = {"선택하세요", "남성", "여성"};    // 성별 옵션
        JComboBox<String> genderCombo = new JComboBox<>(genders); // 콤보박스 생성
        panel.add(genderCombo);
        
        // ----- 7. 이메일 입력 -----
        // ----- 7. 邮箱输入 -----
        panel.add(new JLabel("이메일:"));                    // 이메일 라벨
        JTextField emailField = new JTextField(15);         // 이메일 입력창
        panel.add(emailField);
        
        // ----- 8. 전화번호 입력 -----
        // ----- 8. 手机号码输入 -----
        panel.add(new JLabel("전화번호:"));                  // 전화번호 라벨
        JTextField phoneField = new JTextField(15);         // 전화번호 입력창
        phoneField.setToolTipText("예: 010-1234-5678");
        panel.add(phoneField);
        
        // ----- 9. 주소 입력 -----
        // ----- 9. 地址输入 -----
        panel.add(new JLabel("주소:"));                      // 주소 라벨
        JTextField addressField = new JTextField(15);       // 주소 입력창
        panel.add(addressField);
        
        // ----- 10. 가입일 (자동 생성 - 읽기 전용) -----
        // ----- 10. 注册日期 (自动生成 - 只读) -----
        panel.add(new JLabel("가입일:"));                    // 가입일 라벨
        
        // 현재 날짜 자동 생성 (YYYY-MM-DD 형식)
        // 自动生成当前日期 (YYYY-MM-DD 格式)
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        JTextField dateField = new JTextField(today, 15);   // 가입일 입력창 (자동 입력)
        dateField.setEditable(false);                       // 수정 불가능 (읽기 전용)
        dateField.setBackground(new Color(240, 240, 240)); // 배경색 회색으로 변경
        panel.add(dateField);
        
        // ----- 11. 회원가입 버튼 (2열 병합) -----
        // ----- 11. 注册按钮 (合并2列) -----
        JButton btn = new JButton("회원가입");
        
        // 버튼 클릭 이벤트 처리 (람다식 사용)
        // 处理按钮点击事件 (使用 Lambda 表达式)
        btn.addActionListener(e -> {
            // 입력값 가져오기
            // 获取输入值
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String confirmPassword = new String(confirmPasswordField.getPassword()).trim();
            String name = nameField.getText().trim();
            String birth = birthField.getText().trim();
            String gender = (String) genderCombo.getSelectedItem();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();
            String joinDate = dateField.getText().trim();
            
            // ----- 유효성 검사 (Validation) -----
            // ----- 有效性验证 -----
            
            // 1) 아이디 확인 (최소 4자 이상)
            // 1) 用户名验证 (最少4位以上)
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "아이디를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                idField.requestFocus();
                return;
            }
            if (id.length() < 4) {
                JOptionPane.showMessageDialog(frame, 
                    "아이디는 최소 4자 이상이어야 합니다!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                idField.requestFocus();
                return;
            }
            
            // 2) 비밀번호 확인 (최소 6자 이상)
            // 2) 密码验证 (最少6位以上)
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;
            }
            if (password.length() < 6) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호는 최소 6자 이상이어야 합니다!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;
            }
            
            // 3) 비밀번호 확인 일치 여부
            // 3) 确认密码匹配验证
            if (confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호 확인을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                confirmPasswordField.requestFocus();
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, 
                    "비밀번호가 일치하지 않습니다!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                confirmPasswordField.requestFocus();
                return;
            }
            
            // 4) 이름 확인
            // 4) 姓名验证
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "이름을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                nameField.requestFocus();
                return;
            }
            
            // 5) 생년월일 확인 (간단한 형식 체크 - YYYY-MM-DD)
            // 5) 出生日期验证 (简单格式检查 - YYYY-MM-DD)
            if (birth.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "생년월일을 입력해주세요! (예: 1990-01-01)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                birthField.requestFocus();
                return;
            }
            if (!birth.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 생년월일 형식이 아닙니다! (예: 1990-01-01)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                birthField.requestFocus();
                return;
            }
            
            // 6) 성별 확인
            // 6) 性别验证
            if (gender.equals("선택하세요")) {
                JOptionPane.showMessageDialog(frame, 
                    "성별을 선택해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                genderCombo.requestFocus();
                return;
            }
            
            // 7) 이메일 확인 (@ 포함 여부)
            // 7) 邮箱验证 (是否包含 @)
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "이메일을 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 이메일 형식이 아닙니다! (예: user@email.com)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }
            
            // 8) 전화번호 확인 (간단한 형식 체크)
            // 8) 手机号码验证 (简单格式检查)
            if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "전화번호를 입력해주세요! (예: 010-1234-5678)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }
            // 숫자, 하이픈(-)만 허용 (간단한 검사)
            if (!phone.matches("[0-9\\-]+")) {
                JOptionPane.showMessageDialog(frame, 
                    "올바른 전화번호 형식이 아닙니다! (예: 010-1234-5678)", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }
            
            // 9) 주소 확인
            // 9) 地址验证
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "주소를 입력해주세요!", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
                addressField.requestFocus();
                return;
            }
            
            // ----- 모든 입력이 정상인 경우 회원 정보 출력 -----
            // ----- 所有输入正常时显示会员信息 -----
            
            // 회원 정보를 표시할 메시지 생성
            // 创建显示会员信息的消息
            String message = "🎉 회원가입 완료! 🎉\n\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "📝 회원 정보\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "아이디    : " + id + "\n"
                           + "비밀번호  : " + "*".repeat(password.length()) + "\n"
                           + "이름      : " + name + "\n"
                           + "생년월일  : " + birth + "\n"
                           + "성별      : " + gender + "\n"
                           + "이메일    : " + email + "\n"
                           + "전화번호  : " + phone + "\n"
                           + "주소      : " + address + "\n"
                           + "가입일    : " + joinDate + "\n"
                           + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                           + "환영합니다! 😊";
            
            // 메시지 다이얼로그로 회원 정보 표시
            // 用消息对话框显示会员信息
            JOptionPane.showMessageDialog(frame, 
                message, 
                "회원가입 성공", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // (선택사항) 입력 필드 초기화
            // (可选) 清空输入字段
            // idField.setText("");
            // passwordField.setText("");
            // confirmPasswordField.setText("");
            // nameField.setText("");
            // birthField.setText("");
            // genderCombo.setSelectedIndex(0);
            // emailField.setText("");
            // phoneField.setText("");
            // addressField.setText("");
        });
        
        // 버튼을 패널에 추가 (마지막 행에 2열 병합)
        // 将按钮添加到面板 (最后一行合并2列)
        panel.add(btn);
        
        // 빈 공간 채우기 (버튼이 2열을 차지하도록)
        // 填充空白 (使按钮占据2列)
        // GridLayout은 11행 2열이므로 22개 셀이 필요함
        // 지금까지: 10개 필드(라벨+입력창) = 20개 + 버튼 1개 = 총 21개
        // 따라서 빈 셀 1개를 추가하여 22개(11행×2열)를 맞춤
        panel.add(new JLabel(""));  // 빈 라벨로 자리 채움
        
        // 메인 프레임에 패널 추가
        // 将面板添加到主框架
        frame.add(panel);
        
        // 메인 프레임 크기 설정
        // 设置主框架大小
        frame.setSize(450, 550);
        
        // 프레임을 화면 중앙에 배치
        // 将窗口置于屏幕中央
        frame.setLocationRelativeTo(null);
        
        // 메인 프레임 닫기 버튼 동작 설정 (프로그램 종료)
        // 设置主框架关闭按钮行为 (程序终止)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 메인 프레임 표시
        // 显示主框架
        frame.setVisible(true);
    }
}