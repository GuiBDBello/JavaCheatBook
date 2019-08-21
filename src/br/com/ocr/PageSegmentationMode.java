package br.com.ocr;

public enum PageSegmentationMode {
	_00_ORIENTATION_AND_SCRIPT_DETECTION_ONLY,
	_01_AUTOMATIC_PAGE_SEGMENTATION_WITH_OSD,
	_02_AUTOMATIC_PAGE_SEGMENTATION_BUT_NO_OSD_OR_OCR,
	_03_FULLY_AUTOMATIC_PAGE_SEGMENTATION_BUT_NO_OSD,
	_04_ASSUME_A_SINGLE_COLUMN_OF_TEXT_OF_VARIABLE_SIZES,
	_05_ASSUME_A_SINGLE_UNIFORM_BLOCK_OF_VERTICALLY_ALIGNED_TEXT,
	_06_ASSUME_A_SINGLE_UNIFORM_BLOCK_OF_TEXT,
	_07_TREAT_THE_IMAGE_AS_A_SINGLE_TEXT_LINE,
	_08_TREAT_THE_IMAGE_AS_A_SINGLE_WORD,
	_09_TREAT_THE_IMAGE_AS_A_SINGLE_WORD_IN_A_CIRCLE,
	_10_TREAT_THE_IMAGE_AS_A_SINGLE_CHARACTER,
	_11_SPARSE_TEXT,
	_12_SPARSE_TEXT_WITH_OSD,
	_13_RAW_LINE
}