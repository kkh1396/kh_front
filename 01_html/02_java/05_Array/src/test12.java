import java.util.Scanner;

public class test12 {
    public static void main(String[] args) {
        String[][] section1 = {
            {"강건강", "남나나"},
            {"도대담", "류라라"},
            {"문미미", "박보배"}
        };

        String[][] section2 = {
            {"송성실", "윤예의"},
            {"진재주", "차천축"},
            {"피풍표", "홍하하"}
        };

        System.out.println("== 1분단 ==");
        for (int i = 0; i < section1.length; i++) {
            for (int j = 0; j < section1[i].length; j++) {
                System.out.print(section1[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("== 2분단 ==");
        for (int i = 0; i < section2.length; i++) {
            for (int j = 0; j < section2[i].length; j++) {
                System.out.print(section2[i][j] + " ");
            }
            System.out.println();
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 학생 이름을 입력하세요 : ");
        String searchName = scanner.nextLine();
        
        for (int i = 0; i < section1.length; i++) {
            for (int j = 0; j < section1[i].length; j++) {
                if (section1[i][j].equals(searchName)) {
                    if (j == 0) {
                        System.out.println("검색하신 " + searchName + " 학생은 1분단 " + (i + 1) + "번째 줄 왼쪽에 있습니다.");
                    } else {
                        System.out.println("검색하신 " + searchName + " 학생은 1분단 " + (i + 1) + "번째 줄 오른쪽에 있습니다.");
                    }
                }
            }
        }
        
        for (int i = 0; i < section2.length; i++) {
            for (int j = 0; j < section2[i].length; j++) {
                if (section2[i][j].equals(searchName)) {
                    if (j == 0) {
                        System.out.println("검색하신 " + searchName + " 학생은 2분단 " + (i + 1) + "번째 줄 왼쪽에 있습니다.");
                    } else {
                        System.out.println("검색하신 " + searchName + " 학생은 2분단 " + (i + 1) + "번째 줄 오른쪽에 있습니다.");
                    }
                }
            }
        }
    }
}
