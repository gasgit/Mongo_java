package ie.gasgit;

/**
 * Created by glen on 11/11/16.
 */
public class Person {

    private String name;
    private String id;
    private String height;
    private String eye_col;


    public Person(String name, String id, String height, String eye_col) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.eye_col = eye_col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEye_col() {
        return eye_col;
    }

    public void setEye_col(String eye_col) {
        this.eye_col = eye_col;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", height='" + height + '\'' +
                ", eye_col='" + eye_col + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
