package HomeWork_09_12_22;

public class program {
/** 
* Ханойская башня
*/
    public static void main(String[] args) {
        int count = 3;                            // количество колец на первой "спице"
        Towers('1', '2', '3', count);     // номера "спиц" для колец при перемещении
    }

    public static void Towers(char a, char b, char c, int count) {

    	if (count==1){
		    System.out.println(String.format("Перемещение с %s --->  %s", a, b));
	    }else {
		    Towers(a, c, b, count - 1);
		    System.out.println(String.format("Перемещение с %s --->  %s", a, b));
	        Towers(c, b, a, count - 1);
    	}

    }
}
