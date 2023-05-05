package javapractice.pra.lotto;

import java.io.*;
import java.util.*;

public class Lotto {
	private static final int LOTTO_SIZE = 7;

	public static void main(String[] args) {
		int[] lottoNumbers = generateLottoNumbers();
		String html = generateHtml(lottoNumbers);
		saveHtml(html);
	}

	public static int[] generateLottoNumbers() {
		int[] lottoNumbers = new int[LOTTO_SIZE];
		Random random = new Random();

		for (int i = 0; i < LOTTO_SIZE; i++) {
			int randomNumber = random.nextInt(45) + 1;
			while (contains(lottoNumbers, randomNumber)) {
				randomNumber = random.nextInt(45) + 1;
			}
			lottoNumbers[i] = randomNumber;
		}

		Arrays.sort(lottoNumbers);
		return lottoNumbers;
	}

	private static boolean contains(int[] array, int number) {
		for (int i : array) {
			if (i == number) {
				return true;
			}
		}
		return false;
	}

	public static String generateHtml(int[] lottoNumbers) {
		StringBuilder sb = new StringBuilder();

		sb.append("<!DOCTYPE html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<meta charset=\"UTF-8\">\n");
		sb.append("<title>로또 번호 생성기</title>\n");
		sb.append("<style>\n");
		sb.append("body {\n");
		sb.append("    background-color: #f5f5f5;\n");
		sb.append("}\n");
		sb.append(".container {\n");
		sb.append("    max-width: 600px;\n");
		sb.append("    margin: 0 auto;\n");
		sb.append("    padding: 20px;\n");
		sb.append("    background-color: #fff;\n");
		sb.append("    border-radius: 5px;\n");
		sb.append("    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);\n");
		sb.append("}\n");
		sb.append("h1 {\n");
		sb.append("    text-align: center;\n");
		sb.append("    font-size: 36px;\n");
		sb.append("    margin-bottom: 30px;\n");
		sb.append("}\n");
		sb.append("ul {\n");
		sb.append("    list-style: none;\n");
		sb.append("    margin: 0;\n");
		sb.append("    padding: 0;\n");
		sb.append("    display: flex;\n");
		sb.append("    justify-content: center;\n");
		sb.append("}\n");
		sb.append("li {\n");
		sb.append("    font-size: 36px;\n");
		sb.append("    margin: 0 10px;\n");
		sb.append("}\n");
		sb.append("</style>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<div class=\"container\">\n");
		sb.append("<h1>로또 번호 생성기</h1>\n");
		sb.append("<ul>\n");
		for (int i : lottoNumbers) {
			sb.append("<li>").append(i).append("</li>\n");
		}
		sb.append("</ul>\n");
		sb.append("</div>\n");
		sb.append("</body>\n");
		sb.append("</html>");
		return sb.toString();
	}

	public static void saveHtml(String html) {
        String filename = "lotto.html";
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(html);
            writer.close();
            System.out.println("HTML 파일이 생성되었습니다.");
        } catch (IOException e) {
            System.out.println("HTML 파일 생성에 실패했습니다.");
        }
    }
}
