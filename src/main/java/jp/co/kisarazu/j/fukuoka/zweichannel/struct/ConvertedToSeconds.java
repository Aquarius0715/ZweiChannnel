package jp.co.kisarazu.j.fukuoka.zweichannel.struct;

public enum ConvertedToSeconds {
    MINUTE(60),
    HOUR(3600),
    DAY(86400)
    ;

    final long seconds;
    ConvertedToSeconds(int seconds) {
        this.seconds = seconds;
    }
}
