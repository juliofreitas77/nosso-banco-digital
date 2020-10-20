package io.github.juliofreitas77.bancodigital.enums;

public enum StatusPropostaEnum {

   // ABERTO, APROVADO, REPROVADO;

    ABERTO(0,"aberto"),
    APROVADO(1,"aprovado"),
    RECUSADO(2,"recusado");
//
//    private int codigo;
    private String desc;
    private int codigo;
//
    private StatusPropostaEnum(int codigo, String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }
//
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static StatusPropostaEnum toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (StatusPropostaEnum e : StatusPropostaEnum.values()) {
            if (id.equals(e.getCodigo())) {
                return e;
            }
        }
        throw new IllegalArgumentException("Id não é válido " + id);
    }
}
