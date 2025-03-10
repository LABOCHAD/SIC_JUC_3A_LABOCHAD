package dingeTesten_LABOCHAD.test;

abstract class Planet {
    protected void revolve() {
    }

    abstract void rotate();
}


class Earth extends Planet {
    protected void revolve() {
    }

    protected void rotate() {} //https://www.examprepper.co/exam/395/14 - Frage 66, C muss mit dazu, also AC oder BC
    //private void rotate() {} //https://www.examprepper.co/exam/395/14 - private ist restriktiver als package private (default) oben
}