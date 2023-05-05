import javax.swing.JOptionPane;

public class ControleRemoto {
    public static void main(String[] args) {

        int ligar = ligarAr();

        if (ligar == -1 || ligar == 1) {
            darAdeus();
        } else {

            int[] resultTemp = pegarTemperatura();

            if (resultTemp[1] == 0) {
                darAdeus();
            } else {
                int temperatura = resultTemp[0];
                int intensidade = pegarIntensidade();
                boolean oscilacao = pegarOscilacao();

                System.out.printf("temp: %d | intensidade: %d | oscilação %b", temperatura, intensidade, oscilacao);

                ArCondicionado ar = new ArCondicionado(temperatura, intensidade, oscilacao);

                exibirAr(ar);
            }
        }

    }

    public static int ligarAr() {

        int ligar = JOptionPane.showConfirmDialog(null, "Deseja ligar o Ar-condicionado?", "Ligar?",
                JOptionPane.YES_NO_OPTION);

        return ligar;

    }

    public static int[] pegarTemperatura() {
        int check = 0;
        int temperatura;
        int[] retorno = new int[2];
        do {
            String numero = JOptionPane.showInputDialog(null, "Qual temperatura você deseja? (-100 até 100)",
                    "Temperatura", 3);
            if (numero == null || numero == "") {
                retorno[1] = 0;
                return retorno;
            } else {
                try {
                    temperatura = Integer.parseInt(numero);

                    retorno[0] = temperatura;
                    retorno[1] = 1;

                    if (temperatura < -100 || temperatura > 100) {
                        JOptionPane.showMessageDialog(null, "Entre -100 e 100, por favor.", "Temperatura", 2);
                    } else {

                        check = 1;
                        return retorno;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor Inválido!", "Erro!", 2);
                }

            }

        } while (check == 0);

        return retorno;
    }

    public static int pegarIntensidade() {

        String[] opcoes = new String[] { "Fraco", "Médio", "Forte" };
        int intesidade = -1;

        do {
            intesidade = JOptionPane.showOptionDialog(null, "Qual intesidade você deseja?", "Intesidade",
                    JOptionPane.DEFAULT_OPTION, 3,
                    null, opcoes, opcoes[0]);

        } while (intesidade == -1);

        return intesidade;

    }

    public static boolean pegarOscilacao() {

        int resposta = -1;

        do {

            int reposta = JOptionPane.showConfirmDialog(null, "Deseja que o ar oscile?", "Oscilação",
                    JOptionPane.YES_NO_OPTION, 3);
            if (reposta == 0) {
                return true;
            } else if (reposta == 1) {
                return false;
            }

        } while (resposta == -1);

        return false;
    }

    public static void darAdeus() {
        JOptionPane.showMessageDialog(null, "Adeus", "Adeus", 0);
    }

    public static void exibirAr(ArCondicionado ar) {

        String[] botoes = new String[] { "Ligar/Desligar ar", "Mudar temperatura", "Mudar intensidade",
                "Ligar/Desligar oscilação" };

        boolean sair = false;
        do {

            int controle = JOptionPane.showOptionDialog(null, ar.toString(), "Ar Condicionado",
                    JOptionPane.DEFAULT_OPTION, 3,
                    null, botoes, botoes[0]);

            switch (controle) {
                case 0:
                    ar.setPower(!ar.isPower());

                    break;

                case 1:

                    if (ar.isPower() == false) {
                        int ligar = ligarAr();
                        if (ligar == 0) {
                            ar.setPower(true);
                            ar.setTemperatura(pegarTemperatura()[0]);
                        }
                    } else {
                        ar.setTemperatura(pegarTemperatura()[0]);
                    }
                    break;

                case 2:
                    if (ar.isPower() == false) {
                        int ligar = ligarAr();
                        if (ligar == 0) {
                            ar.setPower(true);
                            ar.setIntesidade(pegarIntensidade());
                        }
                    } else {
                        ar.setIntesidade(pegarIntensidade());
                    }
                    break;

                case 3:
                    if (ar.isPower() == false) {
                        int ligar = ligarAr();
                        if (ligar == 0) {
                            ar.setPower(true);
                            ar.setOscilacao(!ar.isOscilacao());
                        }
                    } else {
                        ar.setOscilacao(!ar.isOscilacao());
                    }
                    break;

                case -1:
                    darAdeus();
                    sair = true;
                    break;
            }

        } while (sair == false);

    }

}
