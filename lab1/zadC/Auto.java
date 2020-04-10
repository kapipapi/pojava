package zadC;

public class Auto {

    float[] przebieg = new float[12];

    Auto() {
        for(int i=0; i<przebieg.length; i++) {
            przebieg[i] = (float) Math.random();
        }
    }

    float srPrzebieg() {
        float sum = 0;
        for(int i=0; i < przebieg.length; i++) {
            sum += przebieg[i];
        }
        return sum / przebieg.length;
    }

}