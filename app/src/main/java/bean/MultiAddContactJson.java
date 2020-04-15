package bean;

import java.util.List;

public class MultiAddContactJson {
    private List<String> phone_numbers;
    private String m_id;

    public List<String> getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(List<String> phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    @Override
    public String toString() {
        return "MultiAddContactJson{" +
                "phone_numbers=" + phone_numbers +
                ", m_id='" + m_id + '\'' +
                '}';
    }
}
