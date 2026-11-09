package pl.pwr.library;

// High Cohesion: Reader odpowiada wyłącznie za dane
// i reprezentację czytelnika biblioteki.
public class Reader {
    private final int id;
    private final String name;
    private final String email;

    public Reader(int id, String name, String email) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Reader ID must be positive.");
        }

        this.id = id;
        this.name = requireText(name, "Name");
        this.email = requireText(email, "Email");
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    field + " cannot be empty.");
        }

        return value.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Reader #" + id + ": " + name + " (" + email + ")";
    }
}