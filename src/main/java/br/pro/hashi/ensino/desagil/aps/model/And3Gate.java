package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {

    private final NandGate nandEsq;
    private final NandGate nandEsqEsq;
    private final NandGate nandCen;
    private final NandGate nandDir;


    public And3Gate() {
        super("AND3", 3);
        //Criando os objetos
        nandEsq = new NandGate();
        nandEsqEsq = new NandGate();
        nandDir = new NandGate();
        nandCen = new NandGate();

        //Conectando
        nandEsq.connect(0, nandEsqEsq);
        nandEsq.connect(1, nandEsqEsq);
        nandCen.connect(0,nandEsq);
        nandDir.connect(0, nandCen);
        nandDir.connect(1, nandCen);
    }

    @Override
    public boolean read() {
        return nandDir.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nandEsqEsq.connect(0, emitter);
                break;

            case 1:
                nandEsqEsq.connect(1, emitter);
                break;

            case 2:
                nandCen.connect(2, emitter);
                break;


            default:

                throw new IndexOutOfBoundsException(inputIndex);
        }
    }
}
