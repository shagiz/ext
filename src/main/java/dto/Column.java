package dto;

public class Column {
    private String text;
    private String dataIndex;
    private int flex;

    public Column(String text, String dataIndex, int flex) {
        this.text = text;
        this.dataIndex = dataIndex;
        this.flex = flex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public int getFlex() {
        return flex;
    }

    public void setFlex(int flex) {
        this.flex = flex;
    }
}
