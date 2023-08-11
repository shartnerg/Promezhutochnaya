public class Main2 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("select * from students where ");
        String name = "Ivanov", country = "Russia", city = "Moscow", age = null;

        if (name != null) {
            builder.append("name=").append(name);

            if (country != null) {
                builder.append(", country=").append(country);

                if (city != null) {
                    builder.append(", city=").append(city);

                    if (age != null) {
                        builder.append(", age=").append(age);
                    }
                }
            }

            System.out.println(builder);
        }
    }
}
