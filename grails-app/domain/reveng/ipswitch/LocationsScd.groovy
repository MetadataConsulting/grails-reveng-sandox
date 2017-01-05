package reveng.ipswitch

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class LocationsScd implements Serializable {

	String locationId
	String providerId
	String organisationType
	String type
	String name
	String alsoKnownAs
	String registrationStatus
	Date registrationDate
	Date deregistrationDate
	Date registeredManagerAbsentDate
	Integer numberOfBeds
	String website
	String postalAddressLine1
	String postalAddressLine2
	String postalAddressTownCity
	String postalAddressCounty
	String region
	String postalCode
	String mainPhoneNumber
	String constituency
	String localAuthority
	Date publicationDate
	String overallRating
	Date reportDate
	Date lastInspection
	String jsonHash
	Date apiCallDate
	String url
	Integer inSourceData
	Date importDate
	Date createdDate
	Integer isLatest
	Date effectiveFrom
	Date effectiveTo
	Long char8AsciiIndex

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append locationId
		builder.append providerId
		builder.append organisationType
		builder.append type
		builder.append name
		builder.append alsoKnownAs
		builder.append registrationStatus
		builder.append registrationDate
		builder.append deregistrationDate
		builder.append registeredManagerAbsentDate
		builder.append numberOfBeds
		builder.append website
		builder.append postalAddressLine1
		builder.append postalAddressLine2
		builder.append postalAddressTownCity
		builder.append postalAddressCounty
		builder.append region
		builder.append postalCode
		builder.append mainPhoneNumber
		builder.append constituency
		builder.append localAuthority
		builder.append publicationDate
		builder.append overallRating
		builder.append reportDate
		builder.append lastInspection
		builder.append jsonHash
		builder.append apiCallDate
		builder.append url
		builder.append inSourceData
		builder.append importDate
		builder.append createdDate
		builder.append isLatest
		builder.append effectiveFrom
		builder.append effectiveTo
		builder.append char8AsciiIndex
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append locationId, other.locationId
		builder.append providerId, other.providerId
		builder.append organisationType, other.organisationType
		builder.append type, other.type
		builder.append name, other.name
		builder.append alsoKnownAs, other.alsoKnownAs
		builder.append registrationStatus, other.registrationStatus
		builder.append registrationDate, other.registrationDate
		builder.append deregistrationDate, other.deregistrationDate
		builder.append registeredManagerAbsentDate, other.registeredManagerAbsentDate
		builder.append numberOfBeds, other.numberOfBeds
		builder.append website, other.website
		builder.append postalAddressLine1, other.postalAddressLine1
		builder.append postalAddressLine2, other.postalAddressLine2
		builder.append postalAddressTownCity, other.postalAddressTownCity
		builder.append postalAddressCounty, other.postalAddressCounty
		builder.append region, other.region
		builder.append postalCode, other.postalCode
		builder.append mainPhoneNumber, other.mainPhoneNumber
		builder.append constituency, other.constituency
		builder.append localAuthority, other.localAuthority
		builder.append publicationDate, other.publicationDate
		builder.append overallRating, other.overallRating
		builder.append reportDate, other.reportDate
		builder.append lastInspection, other.lastInspection
		builder.append jsonHash, other.jsonHash
		builder.append apiCallDate, other.apiCallDate
		builder.append url, other.url
		builder.append inSourceData, other.inSourceData
		builder.append importDate, other.importDate
		builder.append createdDate, other.createdDate
		builder.append isLatest, other.isLatest
		builder.append effectiveFrom, other.effectiveFrom
		builder.append effectiveTo, other.effectiveTo
		builder.append char8AsciiIndex, other.char8AsciiIndex
		builder.isEquals()
	}

	static mapping = {
		id composite: ["locationId", "providerId", "organisationType", "type", "name", "alsoKnownAs", "registrationStatus", "registrationDate", "deregistrationDate", "registeredManagerAbsentDate", "numberOfBeds", "website", "postalAddressLine1", "postalAddressLine2", "postalAddressTownCity", "postalAddressCounty", "region", "postalCode", "mainPhoneNumber", "constituency", "localAuthority", "publicationDate", "overallRating", "reportDate", "lastInspection", "jsonHash", "apiCallDate", "url", "inSourceData", "importDate", "createdDate", "isLatest", "effectiveFrom", "effectiveTo", "char8AsciiIndex"]
        locationId column: 'locationId'
        providerId column: 'providerId'
        organisationType column: 'organisationType'
        alsoKnownAs column: 'alsoKnownAs'
        registrationStatus column: 'registrationStatus'
        registrationDate column: 'registrationDate'
        deregistrationDate column: 'deregistrationDate'
        registeredManagerAbsentDate column: 'registeredManagerAbsentDate'
        numberOfBeds column: 'numberOfBeds'
        postalAddressLine1 column: 'postalAddressLine1'
        postalAddressLine2 column: 'postalAddressLine2'
        postalAddressTownCity column: 'postalAddressTownCity'
        postalAddressCounty column: 'postalAddressCounty'
        postalCode column: 'postalCode'
        mainPhoneNumber column: 'mainPhoneNumber'
        constituency column: 'constituency'
        localAuthority column: 'localAuthority'
        publicationDate column: 'publicationDate'
        overallRating column: 'overallRating'
        reportDate column: 'reportDate'
        lastInspection column: 'lastInspection'
        char8AsciiIndex column: 'Char_8_ASCII_Index'
		version false
	}

	static constraints = {
		locationId maxSize: 15
		providerId nullable: true, maxSize: 15
		organisationType nullable: true, maxSize: 50
		type nullable: true, maxSize: 50
		name nullable: true
		alsoKnownAs nullable: true
		registrationStatus nullable: true, maxSize: 50
		registrationDate nullable: true
		deregistrationDate nullable: true
		registeredManagerAbsentDate nullable: true
		numberOfBeds nullable: true
		website nullable: true
		postalAddressLine1 nullable: true, maxSize: 100
		postalAddressLine2 nullable: true, maxSize: 100
		postalAddressTownCity nullable: true, maxSize: 100
		postalAddressCounty nullable: true, maxSize: 100
		region nullable: true, maxSize: 100
		postalCode nullable: true, maxSize: 12
		mainPhoneNumber nullable: true, maxSize: 25
		constituency nullable: true, maxSize: 100
		localAuthority nullable: true, maxSize: 100
		publicationDate nullable: true
		overallRating nullable: true, maxSize: 50
		reportDate nullable: true
		lastInspection nullable: true
		effectiveFrom nullable: true
		effectiveTo nullable: true//, unique: ["locationId"]
		char8AsciiIndex nullable: true
	}
}
