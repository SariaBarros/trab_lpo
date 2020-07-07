public class Data{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }
    public void setDia(int dia){
       if(dia > 0 && dia <= 31)
            this.dia = dia;
    }

    public void setMes(int mes){
       if(mes <= 12){
          this.mes = mes; 
            if(mes == 2 && dia > 29){
                dia = 0;
            }
           else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if(dia == 31){
                    dia = 0;
                }
           }
       }
    }

    public void setAno(int ano){
        if(ano > 0){
            this.ano = ano;
            if(ano%4 != 0){
                if(dia == 29 && mes == 2){
                    dia = 0;
                }
            }
        }
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }
}