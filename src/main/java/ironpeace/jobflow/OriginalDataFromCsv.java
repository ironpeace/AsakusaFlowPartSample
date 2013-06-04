package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.csv.AbstractOriginalDataCsvInputDescription;

public class OriginalDataFromCsv 
	extends AbstractOriginalDataCsvInputDescription {

	@Override
	public String getBasePath() {
		return "fps/input";
	}

	@Override
	public String getResourcePattern() {
		return "OriginalData.csv";
	}

}
