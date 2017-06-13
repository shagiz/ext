package dto;

public class Column {
    private String text;
    private String dataIndex;
    private int flex;
    private boolean allowBlank;
    private boolean readOnly;
    private String fieldType;
    private int fieldLength;


    public Column(String text, String dataIndex, int flex, boolean allowBlank, boolean readOnly, String fieldType, int fieldLength) {
        this.text = text;
        this.dataIndex = dataIndex;
        this.flex = flex;
        this.allowBlank = allowBlank;
        this.readOnly = readOnly;
        this.fieldType = fieldType;
        this.fieldLength = fieldLength;
    }

    public boolean isAllowBlank() {
        return allowBlank;
    }

    public void setAllowBlank(boolean allowBlank) {
        this.allowBlank = allowBlank;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
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

    public int getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }
}
