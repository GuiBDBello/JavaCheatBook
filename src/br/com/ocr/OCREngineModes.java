package br.com.ocr;

public enum OCREngineModes {
	_00_LEGACY_ENGINE_MODE("0"),
	_01_NEURAL_NETS_LSTM_ENGINE_ONLY("1"),
	_02_LEGACY_PLUS_LSTM_ENGINES("2"),
	_03_DEFAULT("3");
	
	private final String value;
	
	public String getValue() {
		return this.value;
	}
	
    private OCREngineModes(String value) {
        this.value = value;
    }
}