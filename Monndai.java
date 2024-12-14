import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monndai {
	
	//問題
	private static String[] questions = {
			"日本の首都を答えよ",
			"宮崎県の市町村の数を答えよ",
			"宮崎県の人口を答えよ（2024年1月1日時点）"
	};
	
	//4択
	private static String[][] options = {
			{"1：東京都", "2：大阪府", "3：神奈川県", "4北海道"},
			{"1：32市町村", "2：17市町村", "3：24市町村", "4：26市町村"},
			{"1：1,547,564", "2：1,058,710", "3：1,235,475", "4：1,326,218"},	
	};
	
	//答えの番号
	private static String[] answer = {
		"1",
		"4",
		"2"
	};
	
	public static void main(String[] arga)throws IOException{
		int score = 0;
			
		//1～4が入力されたときにやり直す
		boolean continueProcessing = true;
		while(continueProcessing) {
		
			for(int i = 0; i < questions.length; i++) {
				System.out.println("問題" + (i + 1) + " : " + questions[i]);
			
				for (String option : options[i]) {
				System.out.println(option);
				}
			
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String str = br.readLine();
					int num = Integer.parseInt(str);
			
			
			
					System.out.println("なたの答えは" + num);
			
					//正解だった場合はスコアを獲得
					if(str.equals(answer[i])) {
						System.out.println("正解です");
						score++;
						
						//1～4以外が入力されたときに問題をやり直す
					}else if(num >= 5){
						System.out.println("1～4で答えてください");
						i--;
						continueProcessing = true;
					}
					else if(num == 0){
						System.out.println("1～4で答えてください");
						i--;
						continueProcessing = true;
					}else {
						System.out.println("不正解です");
					}
				
				}catch (NumberFormatException e) {
					System.out.println("１～4の数字を入力してください");
					i--;
					continueProcessing = true;
			
				}
			}
		}
		
		//最終スコアの表示
		System.out.println("あなたのスコアは" + score + "/" + answer.length);
	}

}
