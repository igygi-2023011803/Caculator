import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField textField;
    private String operator = "";
    private double num1, num2;

    public Main() {
        // JFrame 설정
        setTitle("계산기"); // 창 제목 설정
        setSize(400, 600); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 시 애플리케이션 종료
        setLayout(new BorderLayout()); // 레이아웃 보더레이아웃으로 설정

        // 입력 필드 패널 설정
        JPanel PanelA = new JPanel();
        PanelA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // 패널 테두리 색깔과 두께 설정
        textField = new JTextField(20); // 텍스트 필드 생성
        textField.setEditable(false); // 텍스트 필드 수정 불가
        textField.setPreferredSize(new Dimension(400, 60)); // 필드 크기 설정
        textField.setFont(new Font("Arial", Font.PLAIN, 20)); // 폰트 설정
        textField.setBorder(BorderFactory.createEmptyBorder()); // 여백 설정
        textField.setHorizontalAlignment(JTextField.CENTER); // 텍스트 중앙 정렬
        PanelA.add(textField); // 패널에 텍스트 필드 추가
        add(PanelA, BorderLayout.NORTH); // 북쪽에 패널 추가

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4)); // 5행 4열의 그리드 레이아웃

        // 버튼 텍스트 배열
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "x",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
                "C", "", "", "Del"
        };

        // 버튼 생성 및 추가
        for (String text : buttons) {
            JButton button = new JButton(text); // 버튼 생성
            button.setFont(new Font("Arial", Font.PLAIN, 26)); // 버튼 폰트 설정
            button.setBackground(Color.BLACK); // 버튼 배경색 설정
            button.setForeground(Color.WHITE); // 버튼 글자색 설정
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // 버튼 테두리 설정
            button.addActionListener(new ButtonClickListener()); // 버튼 클릭 리스너 추가
            buttonPanel.add(button); // 버튼 패널에 버튼 추가
        }

        add(buttonPanel, BorderLayout.CENTER); // 중앙에 버튼 패널 추가
        setVisible(true); // 창 보이기
    }

    // 버튼 클릭 리스너 클래스
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // 클릭된 버튼의 텍스트 가져오기

            // 숫자 버튼 클릭 처리
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                textField.setText(textField.getText() + command); // 입력 필드에 숫자 추가
            }
            // 초기화 버튼 클릭 처리
            else if (command.equals("C")) {
                textField.setText(""); // 입력 필드 초기화
                operator = ""; // 연산자 초기화
                num1 = num2 = 0; // 숫자 초기화
            }
            // 삭제 버튼 클릭 처리
            else if (command.equals("Del")) {
                String currentText = textField.getText(); // 현재 텍스트 가져오기
                if (currentText.length() > 0) {
                    textField.setText(currentText.substring(0, currentText.length() - 1)); // 마지막 문자 삭제
                }
            }
            // '=' 버튼 클릭 처리
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText()); // 두 번째 숫자 입력
                switch (operator) { // 연산자에 따른 계산
                    case "+":
                        textField.setText(String.valueOf(num1 + num2)); // 덧셈
                        break;
                    case "-":
                        textField.setText(String.valueOf(num1 - num2)); // 뺄셈
                        break;
                    case "x":
                        textField.setText(String.valueOf(num1 * num2)); // 곱셈
                        break;
                    case "/":
                        if (num2 != 0) {
                            textField.setText(String.valueOf(num1 / num2)); // 나눗셈
                        } else {
                            textField.setText("Error"); // 0으로 나누기 에러 처리
                        }
                        break;
                }
                operator = ""; // 연산자 초기화
            }
            // 연산자 버튼 클릭 처리
            else {
                if (!operator.isEmpty()) {
                    return; // 이미 연산자가 설정된 경우 무시
                }
                operator = command; // 연산자 설정
                num1 = Double.parseDouble(textField.getText()); // 첫 번째 숫자 입력
                textField.setText(""); // 입력 필드 초기화
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        new Main(); // 계산기 실행
    }
}
