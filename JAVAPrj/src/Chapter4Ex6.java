import java.io.IOException;


public class Chapter4Ex6 {

   public static void main(String[] args) throws IOException {
	   
	   String s1 = Integer.toString(12);
	   String s2 = String.valueOf(12);
	   int x = Integer.parseInt("12");

	   
	   String name1 = "아이유";
	   String name2 = "아이유";
	   String name3 = new String("아이유");
	   
	   System.out.println(name1 == name2);
	   System.out.println(name2.equals(name3));
	   //==,equals()
	   
	   
//	   String name = "hong";
//	   String lastname = name.toUpperCase();
//	   System.out.println(name + "," + lastname);
		
	   
	   String fileName = "photo.jpg,aa.png,bb.gif";
	   String fileNames = "photo.jpg,aa.png,bb.gif,cc.png"; //CSV 파일
	   
	   System.out.println(fileName.length()); //9
	   System.out.println(fileName.indexOf(".")); //5
	   System.out.println(fileName.substring(0,5)); //photo
	   
	   String name = fileName.substring(0,fileName.indexOf("."));
	   System.out.println(name); //photo
	   
	   String ext = fileName.substring(fileName.indexOf(".")+1);
	   System.out.println(ext);
   
	   String[] names = fileNames.split(",");
	   System.out.println(names.length);
	   System.out.println(names[0]);
	   System.out.println(names[1]);
	   
   }

}