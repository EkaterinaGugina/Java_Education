package HomeWork_16_12_22;
 
import java.util.Random;
 
public class Main extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception{
        options(primaryStage);
        generateMaze();
 
        showMaze();
        //setShortWay();
    }
 
    int width = 20;
    int height = 20;
 
    GameObject[][] maze = new GameObject[height][width];
    ImageView[][] images = new ImageView[height][width];
 
    enum GameObject {
        HALL, WALL, CHAR, FLAG
    };
 
    Image hall = new Image("/img/hall.png");
    Image character = new Image("/img/char.png");
    Image flag = new Image("/img/finish.png");
    Image wall = new Image("/img/wall.png");
 
    GridPane layout; // менеджер компоновки. по сути, это панель, на которую
    // определЄнным образом выкладываютс¤ различные элементы управлени¤
 
    Stage stage; // ссылка на окно приложени¤
    Scene scene; // ссылка на клиентскую область окна
 
    Random r = new Random();
 
    int smileX = 0;
    int smileY = 2; // стартова¤ позици¤ игрового персонажика
    int startSmileX = 0;
    int startSmileY = 2; // стартова¤ позици¤ игрового персонажика
 
    public void options(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("The most short way"); // установка текста в заголовке окна
        stage.setResizable(false); // размеры окна нельз¤ будет изменить
        stage.getIcons().add(character); // иконка приложени¤
        ////////////////////////////////////////////////////////////////////////
        /// настройки панели элементов
        layout = new GridPane(); // элементы будут выкладыватьс¤ в виде сетки
        layout.setPadding(new Insets(5, 5, 5, 5)); // отступы панели от клиентской части окна
        layout.setStyle("-fx-background-color: rgb(92, 118, 137);"); // фон панели
        // layout.setGridLinesVisible(true); // сделать видимыми границы сетки
        /// жутка¤ процедура установки количества строк и столбцов панели:
        for (int i = 0; i < height; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / height);
            layout.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < width; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / width);
            layout.getColumnConstraints().add(colConst);
        }
        ////////////////////////////////////////////////////////////////////////
        /// настройка клиентской области окна: элементы кладЄм на панель, панель -
        // на клиентскую область, клиентскую область - прив¤зываем к окну
        scene = new Scene(layout, 16 * width, 16 * height); // 16 px - размер
        // одной ¤чейки лабиринта по ширине и по высоте
        stage.setScene(scene);
    }
 
    public void generateMaze() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
 
                maze[y][x] = GameObject.HALL; // изначально, лабиринт пустой
 
                // стены по периметру об¤зательны
                if (y == 0 || x == 0 || y == height - 1 | x == width - 1) {
                    maze[y][x] = GameObject.WALL;
                }
 
                // в 1 случае из 5 - ставим стену
                if (r.nextInt(8) == 1) {
                    maze[y][x] = GameObject.WALL;
                }
 
                // наш персонажик
                if (x == 0 && y == 2) {
                    maze[y][x] = GameObject.CHAR;
                }
 
                // есть выход, и соседн¤¤ ¤чейка справа всегда свободна
                if (x == 1 && y == 2 || x == width - 1 && y == height - 3) {
                    maze[y][x] = GameObject.HALL;
                    maze[height - 3][width - 1] = GameObject.FLAG;
 
                }
 
 
            }
        }
 
    }
 
    public void showMaze() {
 
        Image current = null;
 
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
 
                if (maze[y][x] == GameObject.FLAG) {
                    current = flag;
                } else if (maze[y][x] == GameObject.HALL) {
                    current = hall;
                } else if (maze[y][x] == GameObject.WALL) {
                    current = wall;
                } else if (maze[y][x] == GameObject.CHAR) {
                    current = character;
                }
 
                images[y][x] = new ImageView(current);
                layout.add(images[y][x], x, y);
                //GridPane.setHalignment(imgView, HPos.CENTER);
 
            }
        }
        stage.show();
    }
 
   public void findPath() {
       for (int i = 0; i < width; i++) {
           for (int j = 0; j < height; j++) {
               
           }
       }
   }
 
    public void setSmile(int x, int y) {
        maze[y][x] = GameObject.CHAR;
        layout.getChildren().remove(images[y][x]);
        images[y][x] = new ImageView(character);
        layout.add(images[y][x], x, y);
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
}
