package abstractClass;

import java.util.Objects;

public abstract  class Sity {

    String sityName;

    public String getSityName() {
        return sityName;
    }
    public void setSityName(String sityName) {
        this.sityName = sityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sity sity)) return false;
        return Objects.equals(sityName, sity.sityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sityName);
    }

    @Override
    public String toString() {
        return  sityName;
    }
}
