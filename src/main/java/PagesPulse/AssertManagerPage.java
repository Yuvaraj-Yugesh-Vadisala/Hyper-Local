package PagesPulse;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.ByteChannel;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AssertManagerPage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public AssertManagerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    final By AssertManagerButton = By.xpath("//span[contains(@class,'icon-creativeimage')]");
    final By LibraryButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-ad-format_templates')]");
    final By FacebookCarouselButton = By.xpath("//div[contains(@class,'oem-library-adformat-action-btn')]//descendant::div[1]");
    final By AddNewButton = By.xpath("//button[contains(@class,'pendo_new_add-new-creative-template')]");
    final By AdTemplateName = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-template-name')]//descendant::input");
    final By ClickOnLanguageDropdownField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-language')]//div[contains(@class,'os-select-dropdown')]");
    final String GenericClickOnLanguageDropdownOptions = ("(//div[contains(@id,'listbox')]//div[contains(@id,'-option')])[%d]");
    final By ClickOnSelectCreativeTypeDropdownField = By.xpath("((//div[contains(@class,'pendo-event-tracker-common-form-component-select-creative-type')])//descendant::div)[1]");
    final String GenericClickOnSelectCreativeTypeDropdownOptions = ("((//div[contains(@id,'listbox')])//div[contains(@id,'-option')])[%d]");
    final By ClickOnLeadFormSelectionDropdownField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-lead-form-selection')]//descendant::div)[1]");
    final String GenericClickOnLeadFormSelectionDropdownOptions = ("(//div[contains(@id,'-option')])[%d]");
    final By ClickOnThisTemplateIsForDropdownField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-this-template-is-for')]//div[contains(@class,'os-drodown-wrapper')]");
    final String GenericClickOnThisTemplateIsForDropdownOptions = ("(//div[contains(@id,'-listbox')]//div[contains(@id,'-option')])[%d]");
    final By MainBodyTextField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-main-body-text')])//div[contains(@class,'dynamic-field-wrapper')]");
    final By ClickOnAddNewButton = By.xpath("//div[contains(@class,'creative-addnew ')]");
    final String GenericHeadlineField = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-headline')])//div[contains(@class,'dynamic-field-wrapper')])[%d]");
    final String GenericDescriptionField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-description')]//div[contains(@class,'dynamic-field-wrapper')])[%d]");
    final String GenericDeleteLinkField = ("(//div[contains(@class,'delete-link')])[%d]");
    final By UploadImageField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-')]//div[contains(@class,'choose-image ')])[1]");
    final By SearchTagsInputField = By.xpath("//div[contains(@class,'creative-selection-search')]//descendant::input");
    final By CreativeLibraryImageSelection = By.xpath("//img[contains(@class,'os-async-img-container')][1]");
    final By CreativeLibraryVideoSelection = By.xpath("(//div[contains(@class,'video-player-wrapper')])[1]");
    final By CreativeLibraryChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]//descendant::span");
    final By ClickOnSelectCallToActionFieldDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-select-call-to-action')]//div[contains(@class,'os-drodown-wrapper')]");
    final String SelectCallToActionFieldDropdown = ("(//div[contains(@id,'-option-')])[%d]");
    final String GenericClickOnCreativeCount = ("(//div[contains(@class,'creative-count')])[%d]");
    final String GenericAddCreativeTagsTagDropdownField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-tag')]//div[contains(@class,'select-dropdown')])[%d]");
    final String GenericAddCreativeTagsTagValueDropdownField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-setting-tags-')]//div[contains(@menuposition,'fixed')])[%d]");
    final String GenericSelectAddCreativeTagsTagNumber = ("//div[contains(@id,'-listbox')]//div[contains(@id,'-option-')][%d]");
    final By SelectAddCreativeTagsTag = By.xpath("//div[contains(@id,'-listbox')]");
    final By CreativeTagsAddButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-add-creative-tags')]//button[contains(@class,'pendo_track_dynamic_list_custom_add_icon_button')]");
    final By CreateButton = By.xpath("//button[contains(@class,'os-button  button-primary')]");
    final String GenericAddCreativeTagsTagDeleteButton = ("(//div[contains(@class,'remove-action pendo_ott_feature_remove_rule_action_button')])[%d]");
    final String GenericSelectTemplateForDropdown = ("(//div[contains(@id,'-option-')])[%d]");
    final By SelectTemplateFor = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-for')]//div[contains(@class,'os-select-dropdown')]");
    final By FacebookProductAdsButton = By.xpath("//div[contains(@class,'oem-library-adformat-action-btn')]//descendant::div[2]");
    final By FacebookDynamicProductAdsButton = By.xpath("//div[contains(@class,'oem-library-adformat-action-btn')]//descendant::div[3]");
    final By FacebookProductAdsHeadLine = By.xpath("((//div[contains(@class,'pendo-event-tracker-common-form-component-headline')])//div[contains(@class,'dynamic-field-wrapper')])[1]");
    final By FacebookProductAdsMediaTypeDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-media-type')]//div[contains(@class,'os-select-dropdown')]");
    final By FacebookProductAdsTemplateForDropdown = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-for')]//descendant::div)[1]");
    final By DestinationURLOnClickOfThisImageField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-destination-url-on-click-of-this-image')]//descendant::div)[1]");
    final String SelectDesiredFacebookProductAdsMediaTypeDropdown = ("(//div[contains(@id,'-listbox')]//div[contains(@id,'-option')])[%d]");

    final By DisabledCreateButton = By.xpath("//button[contains(@class,'os-button  button-primary') and contains(@class,'disabled')]");
    final By GoogleSearchAdsButton = By.xpath("//div[contains(@class,'oem-library-adformat-action-btn')]//descendant::div[4]");
    final By CreateNewAdButton = By.xpath("//button[contains(@class,'pendo_new_create_new btn')]/span");
    final By CreativeName = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-template-name')]//input");
    final By CreativeTypeDropDown = By.xpath("((//div[contains(@class,'pendo-event-tracker-common-form-component-select-creative-type')])//descendant::div)[1]");
    final By CampaignForDropdown = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-for')]//descendant::div)[1]");
    final String CampaignForOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CreativeTypeOption = By.xpath("(//div[contains(@class,'Select__option')])[1]");
    final By ThisTemplateForDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-this-template-is-for')]//div[contains(@class,'os-drodown-wrapper')]");
    final String ThisTemplateForDropdownOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CountryCodeField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-country-code')]/div[1]");
    final String CountryCodeDynamicOptions = ("(//ul[contains(@class,'options-list')]/li)[%d]");
    final By PhoneNumberField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-phone-number')]//div[contains(@class,'dynamic-field-wrapper')])[1]");
    final String PhoneNumberDynamicOptions = ("((//ul[contains(@class,'options-list')])[2]/li)[%d]");
    final By PhoneNumberVerificationUrlField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-phone-number')]//div[contains(@class,'dynamic-field-wrapper')])[2]");
    final By BusinessNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-business-name')]//div[contains(@class,'dynamic-field-wrapper')]");
    final String PhoneNumberVerificationUrlDynamicOptions = ("((//ul[contains(@class,'options-list')])[3]/li)[%d]");
    final By Description1Field = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-description-')]//div[contains(@class,'dynamic-field-wrapper')])[1]");
    final String BusinessNameDynamicOptions = ("((//ul[contains(@class,'options-list')])[4]/li)[%d]");
    final By Description2Field = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-description-')]//div[contains(@class,'dynamic-field-wrapper')])[2]");
    final String Description1DynamicOption = ("((//ul[contains(@class,'options-list')])[5]/li)[%d]");
    final By WebsiteUrlField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-website-url')]//div[contains(@class,'dynamic-field-wrapper')]");
    final String Description2DynamicOption = ("((//ul[contains(@class,'options-list')])[6]/li)[%d]");
    final By DomainField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-domain')]//div[contains(@class,'dynamic-field-wrapper')]");
    final String WebsiteUrlDynamicOption = ("((//ul[contains(@class,'options-list')])[7]/li)[%d]");
    final String DomainDynamicOption = ("((//ul[contains(@class,'options-list')])[8]/li)[%d]");
    final By FinalURLField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-final-url')]//div[contains(@class,'dynamic-field-wrapper')])");
    final By Headline1Field = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-1')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By DisplayURLField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-display-url')]//div[contains(@class,'dynamic-field-wrapper')])");
    final String FinalURLDynamicOptions = ("(//ul[contains(@class,'options-')]/li)[%d]");
    final String Headline1DynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-headline-1')]/descendant::ul[contains(@class,'options-')]/li)[%d]");
    final String Headline2DynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-headline-2')]/descendant::ul[contains(@class,'options-')]/li)[%d]");
    final String Headline3DynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-headline-3')]/descendant::ul[contains(@class,'options-')]/li)[%d]");
    final String Headline4DynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-headline-4')]/descendant::ul[contains(@class,'options-')]/li)[%d]");
    final String ResponsiveSearchAdDescription1DynamicOptions = ("((//ul[contains(@class,'options-list')])[7]/li)[3]");
    final String ResponsiveSearchAdDescription2DynamicOptions = ("((//ul[contains(@class,'options-list')])[8]/li)[3]");
    final String ResponsiveSearchAdDescription3DynamicOptions = ("((//ul[contains(@class,'options-list')])[9]/li)[3]");
    final String DisplayURLDynamicOptions = ("(//ul[contains(@class,'options-list')]//descendant::li[2])[2]");
    final String PinPositionDynamicOptions = ("(//div[contains(@class,'pin-option')])[%d]");
    final By HeadLine2Field = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-2')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By HeadLine3Field = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-3')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By HeadLine4Field = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-4')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By HeadLineAddButton = By.xpath("(//button[contains(@class,'pin-addrow')]/descendant::span)[1]");
    final By DescriptionAddButton = By.xpath("(//button[contains(@class,'pin-addrow')]/descendant::span)[2]");
    final By HeadLine4DeleteButton = By.xpath("(//div[contains(@class,'form-component-pinform')][4])//div[contains(@class,'icon-trash')]");
    final By Description3DeleteButton = By.xpath("((//div[contains(@class,'form-component-pinform')][3])//div[contains(@class,'icon-trash')])[2]");
    final By HeadLine4PinButton = By.xpath("(//div[contains(@class,'form-component-pinform')][4])//div[contains(@class,'pin-tack')]");
    final By Description3PinButton = By.xpath("((//div[contains(@class,'form-component-pinform')][3])//div[contains(@class,'pin-tack')])[2]");
    final By Description3Field = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-description-')]//div[contains(@class,'dynamic-field-wrapper')])[3]");
    final By TagField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-tag-')]//div[contains(@class,'os-drodown-wrapper')]");
    final By FacebookCarouselTemplateSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By TemplateApprovedStatus = By.xpath("//td[contains(@class,'status-dropdown-transparent')]/descendant::span[contains(@class,'status-displayname Approved')]");
    final By SelectPartnerField = By.xpath("//div[contains(@class,'form-partner-selection-dropdown')]/descendant::div[contains(@class,'Select__value-container')]");
    final String DescriptionTextField = "(//div[contains(@class,'pendo-event-tracker-common-form-component-description')]/descendant::textarea)[%d]";
    final By DestinationUrlFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-destination-url-on-click-of-this-image')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By DisabledCreativeLibraryChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button') and contains(@class,'disabled')]");
    final By TagValueEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-setting-tags-')]/descendant::div[contains(@class,'name-error-message')]/div");
    final By DuplicateAdNameErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By FinalUrlFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-final-url')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By DisplayUrlFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-display-url')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By HeadLine1FieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-1')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By HeadLine2FieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-2')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By HeadLine3FieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-headline-3')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By Description1FieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-description-1')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By Description2FieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-description-2')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By FinalUrlInvalidUrlErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-final-url')]/descendant::div[contains(@class,'pendo-track-common-error-for-invalid-url')]/div");
    final By GooglePerformanceMaxAdsButton = By.xpath("//div[contains(@class,'oem-library-adformat-action-btn')]//descendant::div[5]");
    final By GooglePerformanceMaxAdsBusinessNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-business-name')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By GooglePerformanceMaxAdsDestinationURLField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-destination-url')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By GooglePerformanceMaxAdsShortHeadlineField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-short-headline')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By GooglePerformanceMaxAdsShortDescriptionField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-short-description')]//div[contains(@class,'dynamic-field-wrapper')]");
    final By GooglePerformanceMaxAdsHeadlinesFirstField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]");
    final By GooglePerformanceMaxAdsLongHeadlinesFirstField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]");
    final By GooglePerformanceMaxAdsDescriptionsFirstField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]");
    final By GooglePerformanceMaxAdsHeadlinesSecondField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]");
    final By GooglePerformanceMaxAdsLongHeadlinesSecondField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]");
    final By GooglePerformanceMaxAdsDescriptionsSecondField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]");
    final By GooglePerformanceMaxAdsHeadlinesThirdField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[3]");
    final By GooglePerformanceMaxAdsHeadlinesThirdFieldDeleteButton = By.xpath("(//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')]/descendant::span)[3]");
    final By GooglePerformanceMaxAdsLongHeadlinesSecondFieldDeleteButton = By.xpath("(//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')]/descendant::span)[2]");
    final By GooglePerformanceMaxAdsDescriptionsSecondFieldDeleteButton = By.xpath("(//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')]/descendant::span)[2]");
    final By GooglePerformanceMaxAdsHeadlinesAddMoreButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]/descendant::button)");
    final By GooglePerformanceMaxAdsLongHeadlinesAddMoreButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]/descendant::button)");
    final By GooglePerformanceMaxAdsDescriptionsAddMoreButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]/descendant::button)");
    final String BusinessNameFieldDynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-business-name')]//descendant::ul[2]/li)[%d]");
    final String DestinationURLFieldDynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-destination-url')]//descendant::ul[2]/li)[%d]");
    final String ShortHeadlineFieldDynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-short-headline')]//descendant::ul[2]/li)[%d]");
    final String ShortDescriptionFieldDynamicOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-short-description')]//descendant::ul[2]/li)[%d]");
    final String HeadlinesFirstFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]//descendant::ul[2]/li)[%d]");
    final String LongHeadlinesFirstFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]//descendant::ul[2]/li)[%d]");
    final String DescriptionsFirstFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[1]//descendant::ul[2]/li)[%d]");
    final String HeadlinesSecondFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]//descendant::ul[2]/li)[%d]");
    final String LongHeadlinesSecondFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]//descendant::ul[2]/li)[%d]");
    final String DescriptionsSecondFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[2]//descendant::ul[2]/li)[%d]");
    final String HeadlinesThirdFieldDynamicOptions = ("((//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]//div[contains(@class,'content-form-box')]/div[contains(@class,'dynamic-field-wrapper')])[3]//descendant::ul[2]/li)[%d]");
    final By GooglePerformanceMaxAdsUploadLogoImagesFirstField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]//div[contains(@class,'creative-image-wrapper')])[1]");
    final By GooglePerformanceMaxAdsUploadLogoImagesSecondField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]//div[contains(@class,'creative-image-wrapper')])[2]");
    final By GooglePerformanceMaxAdsUploadLogoImagesSecondFieldDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[2]");
    final By GooglePerformanceMaxAdsUploadLogoImagesThirdField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]//div[contains(@class,'creative-image-wrapper')])[3]");
    final By GooglePerformanceMaxAdsLogoImagesAddMoreField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]//button[contains(@class,'os-button')]");
    final By GooglePerformanceMaxAdsLogoImagesCreativeLibraryFirstImage = By.xpath("(//img[contains(@class,'os-async-img-container')])[1]");
    final By GooglePerformanceMaxAdsLogoImagesCreativeLibraryChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]//descendant::span");
    final By GooglePerformanceMaxAdsLogoImagesCreativeLibrarySearchTagsInputField = By.xpath("//div[contains(@class,'creative-selection-search')]//descendant::input");
    final By GooglePerformanceMaxAdsVideosAddVideoButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-videos')]//button[contains(@class,'os-button')]/span)[2]");
    final By GooglePerformanceMaxAdsVideosFirstYouTubeURLField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-videos')]//div[contains(@class,'input-wrapper')])[1]");
    final By GooglePerformanceMaxAdsVideosSecondYouTubeURLField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-videos')]//div[contains(@class,'input-wrapper')])[2]");
    final By GooglePerformanceMaxAdsVideosSecondYouTubeURLDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-videos')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[2]");
    final By GooglePerformanceMaxAdsSquareMarketingFirstImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-squareimages')]//div[contains(@class,'creative-image-wrapper')])[1]");
    final By GooglePerformanceMaxAdsOptionalPortraitMarketingFirstImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-portraitimages')]//div[contains(@class,'creative-image-wrapper')] )[1]");
    final By GooglePerformanceMaxAdsOptionalLandscapeMarketingFirstImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-landscapeimages')]//div[contains(@class,'creative-image-wrapper')])[1]");
    final By GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-portraitimages')]//div[contains(@class,'creative-image-wrapper')] )[2]");
    final By GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-landscapeimages')]//div[contains(@class,'creative-image-wrapper')])[2]");
    final By GooglePerformanceMaxAdsSquareMarketingAddMoreButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-squareimages')]//button[contains(@class,'os-button')]");
    final By GooglePerformanceMaxAdsOptionalPortraitMarketingAddMoreButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-portraitimages')]//button[contains(@class,'os-button')] ");
    final By GooglePerformanceMaxAdsOptionalLandscapeMarketingAddMoreButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-landscapeimages')]//button[contains(@class,'os-button')]");
    final By GooglePerformanceMaxAdsSquareMarketingSecondImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-squareimages')]//div[contains(@class,'creative-image-wrapper')])[2]");
    final By GooglePerformanceMaxAdsSquareMarketingSecondImageDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-squareimages')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[2]");
    final By GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImageDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-portraitimages')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')] )[2]");
    final By GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImageDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-landscapeimages')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[2]");
    final By GooglePerformanceMaxAdsMarketingSecondImageDeleteButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-rectangleimages')]//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[2]");
    final By GooglePerformanceMaxAdsMarketingFirstImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-rectangleimages')]//div[contains(@class,'creative-image-wrapper')])[1]");
    final By GooglePerformanceMaxAdsMarketingSecondImage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-rectangleimages')]//div[contains(@class,'creative-image-wrapper')])[2]");
    final By GooglePerformanceMaxAdsMarketingAddMoreButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-rectangleimages')]//button[contains(@class,'os-button')]");
    final By GooglePerformanceMaxAdsOptionalImagesToggleButton = By.xpath("//span[contains(@class,'os-toggle-switch-round')]");
    final By GooglePerformanceMaxAdsCreateButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button");
    final By GooglePerformanceMaxAdsYouTubeURLVideoCloseButton = By.xpath("//div[contains(@class,'modal-content')]//descendant::button");
    final By YoutubePreviewButton = By.xpath("//button[contains(@class,'youtube-preview-button')]/span");
    final By BusinessNameFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-business-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By GoogleAdDestinationUrlFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-destination-url')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By ShortHeadLineFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-short-headline')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By ShortDescriptionFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-short-description')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By HeadlineWarningRedLine = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]/descendant::div[contains(@class,'has-error-block')]");
    final By GoogleHeadLine1FieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div)[1]");
    final By GoogleHeadLine2FieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-headlines')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div)[2]");
    final By LongHeadlinesWarningRedLine = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]/descendant::div[contains(@class,'has-error-block')]");
    final By LongHeadLineFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-longheadlines')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By DescriptionFieldWarningRedLine = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]/descendant::div[contains(@class,'has-error-block')]");
    final By GoogleDescriptionFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-text-descriptions')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By LogoImagesWarningRedLine = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]/descendant::div[contains(@class,'has-error-block')]");
    final By LogoImageFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-logoimages')]/descendant::div[contains(@class,'name-error-message')]/div");
    final By ImagesFieldWarningRedLine = By.xpath("//div[contains(@class,'images-selection-form-wrapper-parent ')]/descendant::div[contains(@class,'has-error-block')]");
    final By SquareMarketingImageFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-squareimages')]/descendant::div[contains(@class,'name-error-message')]/div");
    final By MarketingImageFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-templatedata-images-rectangleimages')]/descendant::div[contains(@class,'name-error-message')]/div");
    final By LibraryTableFirstTemplate = By.xpath("//input[contains(@id,'TableWrapper_ads_table_view-0')]/parent::div/descendant::label");
    final By ArchiveTemplateButton = By.xpath("//button[contains(@class,'pendo_new_template_archival')]");
    final By AddCommentsTextAreaField = By.xpath("//div[contains(@class,'textarea-wrapper')]/textarea");
    final By ArchiveTemplateSuccessPopup = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By AllActionsButton = By.xpath("//button[contains(@class,'pendo_new_all_actions_library')]/span");
    final By AllActionsTemplateCommentText = By.xpath("((//table[contains(@class,'table sticky-header sticky')])[2]/descendant::div[contains(@class,'ellipsis-cell-overflow ')]/descendant::span)[1]");
    final By TemplateReviewButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-seller-templates_approval')]/div");
    final By ReviewTableUnderReviewTemplateIcon = By.xpath("(//div[contains(@class,'status-dropdown-container-new')]/descendant::span[contains(@class,'status-displayname Under Review')])[1]");
    final By ReviewTextButton = By.xpath("//button[contains(@class,'pendo_new_review_btn')]/span");
    final By CommentField = By.xpath("//div[contains(@class,'review-comments-wrapper')]/descendant::textarea");
    final By ReviewAdTemplateNameText = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-template-name')]/descendant::span");
    final By RejectButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button[contains(@class,'button-danger ')]");
    final By CommentAndRejectButton = By.xpath("//div[contains(@class,'pendo_feature_review_comment_and_reject_button no-options')]");
    final By TemplateRejectedSuccessPopUp =By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By FilteredPillButton = By.xpath("//span[contains(@class,'pendo_feature_filter_pill ')]/span");
    final By RejectedTemplateText = By.xpath("//div[contains(@class,'status-dropdown-container-new ')]/descendant::span[contains(@class,'status-displayname Rejected')]");
    final By CommentIcon = By.xpath("//button[contains(@class,'pendo_new_add-comment-btn')]/span");
    final By CommentOnlyButton = By.xpath("//div[contains(@class,'pendo_feature_review_comment_only_button')]");
    final By CommentFieldWarningRedLine = By.xpath("//textarea[contains(@class,'form-control error-control')]");
    final By CommentEmptyText = By.xpath("(//div[contains(@class,'comment-info right') and not(.//p) ])[last()]");
    final By ApproveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer flex-row')]/descendant::button)[2]");
    final By TemplateApprovedSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By TemplateApproveIcon = By.xpath("//div[contains(@class,'status-dropdown-container-new')]/descendant::span[contains(@class,'status-displayname Approved')]");
    final By TableHeadings = By.xpath("//th[not(contains(@data-sticky-td,'true'))]");

    final By AddOrRemoveColumns = By.xpath("//div[contains(@class,'pendo-track-react-table-dynamic-column-click')]/descendant::label");

    final String AddOrRemoveTableHeadingsSelector  = "(//input[contains(@id,'checkbox')]/parent::div[contains(@class,'selected')]/descendant::label)[%d]";
    final String AddOrRemoveTableHeadingsDeselector = "(//input[contains(@id,'checkbox')]/parent::div[not(contains(@class,'selected'))]/descendant::label)[%d]";
    final By TableCompactViewButton = By.xpath("//input[contains(@id,'CARDS-')]/parent::div/descendant::label");
    final By TemplatesInCardView = By.xpath("(//div[contains(@class,'ads-cards-wrapper')]/descendant::div[contains(@class,'ads-view-title-block')])[1]");

    @Step("Click on Assert Manager Button")
    public void ClickOnAssertManagerButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AssertManagerButton));
        driver.findElement(AssertManagerButton).click();
    }

    @Step("Click on Select Library Button")
    public void SelectLibrary() {
        wait.until(ExpectedConditions.elementToBeClickable(LibraryButton));
        driver.findElement(LibraryButton).click();
    }

    @Step("Click on Select Facebook Carousel Button")
    public void SelectFacebookCarousel() {
        wait.until(ExpectedConditions.elementToBeClickable(FacebookCarouselButton));
        driver.findElement(FacebookCarouselButton).click();
    }

    @Step("Click on Add New Button")
    public void ClickAddNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewButton));
        driver.findElement(AddNewButton).click();
    }


    public String FacebookCarouselLeadAD;

    @Step("Entering Ad Template Name")
    public void EnterAdTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        FacebookCarouselLeadAD = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }

    @Step("Selecting desired Language Selection")
    public void SelectDesiredLanguage(int option) {

        WebElement element = driver.findElement(ClickOnLanguageDropdownField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnLanguageDropdownField));
        driver.findElement(ClickOnLanguageDropdownField).click();
        String XpathFormatter = String.format(GenericClickOnLanguageDropdownOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired Creative type Selection")
    public void SelectDesiredCreativeType(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnSelectCreativeTypeDropdownField));
        driver.findElement(ClickOnSelectCreativeTypeDropdownField).click();
        String XpathFormatter = String.format(GenericClickOnSelectCreativeTypeDropdownOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired Lead Form Selection")
    public void SelectDesiredLeadFormSelection(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnLeadFormSelectionDropdownField));
        driver.findElement(ClickOnLeadFormSelectionDropdownField).click();
        String XpathFormatter = String.format(GenericClickOnLeadFormSelectionDropdownOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting This Template Is For")
    public void SelectingThisTemplateIsFor(String templateIsFor, int Index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnThisTemplateIsForDropdownField));
        driver.findElement(ClickOnThisTemplateIsForDropdownField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(templateIsFor);
        String ThisTemplateIsForDropdownIndex = String.format(GenericClickOnThisTemplateIsForDropdownOptions, Index);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ThisTemplateIsForDropdownIndex)));
        driver.findElement(By.xpath(ThisTemplateIsForDropdownIndex)).click();
    }

    @Step("Entering Main Body Text")
    public void EnterMainBodyText(String mainBodyText) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(DescriptionTextField, 1)))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainBodyTextField));
        driver.findElement(MainBodyTextField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(mainBodyText);
    }

    @Step("Scroll UpTo Select Call To Action Field")
    public void ScrollToSelectCallToActionField() {
        WebElement element = driver.findElement(ClickOnSelectCallToActionFieldDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnSelectCallToActionFieldDropdown));
    }

    @Step("Entering Headline Text")
    public void EnterHeadlineText(String headlineText, int clickOnCreativeCount, int headlineCount) {
        String CreativeCountXpathFormatter = String.format(GenericClickOnCreativeCount, clickOnCreativeCount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreativeCountXpathFormatter)));
        driver.findElement(By.xpath(CreativeCountXpathFormatter)).click();
        String HeadlineFieldXpathFormatter = String.format(GenericHeadlineField, headlineCount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HeadlineFieldXpathFormatter)));
        driver.findElement(By.xpath(HeadlineFieldXpathFormatter)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadlineFieldXpathFormatter));
//        driver.findElement(HeadlineFieldXpathFormatter).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(headlineText);
    }


    @Step("Entering headline text")
    public void EnterHeadLineText(int option, String headlineText) {//check
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(String.format(DescriptionTextField, 1))));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(DescriptionTextField, option)))).perform();
        String XpathFormatted = String.format(GenericHeadlineField, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatted))).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(headlineText);
    }

    @Step("Click delete link")
    public void ClickDeleteLink(int clickOnDeleteLinkCount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnAddNewButton));
        driver.findElement(ClickOnAddNewButton).click();
        String CreativeCountXpathFormatter = String.format(GenericClickOnCreativeCount, clickOnDeleteLinkCount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreativeCountXpathFormatter)));
        driver.findElement(By.xpath(CreativeCountXpathFormatter)).click();
        String DeleteLinkXpathFormatter = String.format(GenericDeleteLinkField, clickOnDeleteLinkCount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeleteLinkXpathFormatter)));
        driver.findElement(By.xpath(DeleteLinkXpathFormatter)).click();

    }

    @Step("Entering Description")
    public void EnterDescription(String descriptionText, int genericDescriptionCount) {
        String DescriptionXpathFormatter = String.format(GenericDescriptionField, genericDescriptionCount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DescriptionXpathFormatter)));
        driver.findElement(By.xpath(DescriptionXpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(descriptionText);
    }

    @Step("Click on Upload Image")
    public void ClickUploadImage() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadImageField));
        driver.findElement(UploadImageField).click();
    }

    @Step("uploading image from Creative Library")
    public void ChooseCreativeLibraryImage(String tagName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchTagsInputField));
        driver.findElement(SearchTagsInputField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(tagName);
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryImageSelection));
        driver.findElement(CreativeLibraryImageSelection).click();
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryChooseButton));
        driver.findElement(CreativeLibraryChooseButton).click();
    }

    @Step("Selecting desired Language Selection")
    public void SelectingDesiredSelectCallToActionDropdown(String actionName, int option) {
        WebElement element = driver.findElement(ClickOnSelectCallToActionFieldDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnSelectCallToActionFieldDropdown));
        driver.findElement(ClickOnSelectCallToActionFieldDropdown).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(actionName);
        String XpathFormatter = String.format(SelectCallToActionFieldDropdown, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired Tag")
    public void SelectingDesiredTagFromDropdown(String tagName, int option, int number) {
        WebElement element = driver.findElement(CreativeTagsAddButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeTagsAddButton));
        String TagXpathFormatter = String.format(GenericAddCreativeTagsTagDropdownField, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TagXpathFormatter)));
        driver.findElement(By.xpath(TagXpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(tagName);
        String XpathFormatter = String.format(GenericSelectAddCreativeTagsTagNumber, number);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Selecting desired Tag value")
    public void SelectingDesiredTagValueFromDropdown(int tagValue, int option) {
        String TagValueXpathFormatter = String.format(GenericAddCreativeTagsTagValueDropdownField, tagValue);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TagValueXpathFormatter)));
        driver.findElement(By.xpath(TagValueXpathFormatter)).click();
        String XpathFormatter = String.format(GenericSelectAddCreativeTagsTagNumber, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking On creative tags add Button")
    public void ClickingCreativeTagsAddButton() {
        WebElement element = driver.findElement(CreativeTagsAddButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnSelectCallToActionFieldDropdown));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeTagsAddButton));
        driver.findElement(CreativeTagsAddButton).click();
    }

    @Step("Clicking On Delete Button")
    public void ClickingTheDeleteButton(int tagNumber) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        String XpathFormatter = String.format(GenericAddCreativeTagsTagDeleteButton, tagNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Click on Create Button")
    public void ClickCreateButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
        driver.findElement(CreateButton).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledCreateButton));
    }

    @Step("select Template For Dropdown From AwarenessAds")
    public void SelectDesiredTemplateForDropdown(int count) {
        wait.until(ExpectedConditions.elementToBeClickable(SelectTemplateFor));
        driver.findElement(SelectTemplateFor).click();
        String XpathFormatter = String.format(GenericSelectTemplateForDropdown, count);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Click on Select Facebook Carousel Button")
    public void SelectFacebookProductAds() {
        wait.until(ExpectedConditions.elementToBeClickable(FacebookProductAdsButton));
        driver.findElement(FacebookProductAdsButton).click();
    }

    @Step("Click on Select Facebook Carousel Button")
    public void SelectFacebookDynamicProductAds() {
        wait.until(ExpectedConditions.elementToBeClickable(FacebookDynamicProductAdsButton));
        driver.findElement(FacebookDynamicProductAdsButton).click();
    }

    @Step("Entering Products Ads Headline Text")
    public void EnterProductAdsHeadlineText(String headlineText) {
//        String CreativeCountXpathFormatter = String.format(GenericClickOnCreativeCount, clickOnCreativeCount);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreativeCountXpathFormatter)));
//        driver.findElement(By.xpath(CreativeCountXpathFormatter)).click();
//        String HeadlineFieldXpathFormatter = String.format(GenericHeadlineField, headlineCount);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HeadlineFieldXpathFormatter)));
//        driver.findElement(By.xpath(HeadlineFieldXpathFormatter)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookProductAdsHeadLine));
        driver.findElement(FacebookProductAdsHeadLine).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(headlineText);
    }

    @Step("Selecting desired Media Type")
    public void SelectingDesiredFacebookProductAdsMediaTypeFromDropdown(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookProductAdsMediaTypeDropdown));
        driver.findElement(FacebookProductAdsMediaTypeDropdown).click();
        String XpathFormatter = String.format(SelectDesiredFacebookProductAdsMediaTypeDropdown, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired Template for Selection")
    public void SelectDesiredTemplateForSelection(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookProductAdsTemplateForDropdown));
        driver.findElement(FacebookProductAdsTemplateForDropdown).click();
        String XpathFormatter = String.format(GenericClickOnLeadFormSelectionDropdownOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering Destination URL On Clicking Of this image")
    public void EnteringDestinationURL(String url) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DestinationURLOnClickOfThisImageField));
        driver.findElement(DestinationURLOnClickOfThisImageField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(url);
    }

    @Step("uploading Video from Creative Library")
    public void EnterTextInSearchTagsNameField(String tagName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchTagsInputField));
        driver.findElement(SearchTagsInputField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(tagName);
    }


    @Step("Selecting Image in Creative Library")
    public void SelectCreativeLibraryImage() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryImageSelection));
        driver.findElement(CreativeLibraryImageSelection).click();
    }

    @Step("Uploading Image from Creative Library")
    public void ChooseCreativeLibraryImage() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryChooseButton));
        driver.findElement(CreativeLibraryChooseButton).click();
    }


    @Step("Click on Select Facebook Carousel Button")
    public void SelectGoogleSearchAds() {
        wait.until(ExpectedConditions.elementToBeClickable(GoogleSearchAdsButton));
        driver.findElement(GoogleSearchAdsButton).click();
    }

    @Step("Clicking on Create New Ad button")
    public void ClickOnCreateNewAdButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateNewAdButton));
        driver.findElement(CreateNewAdButton).click();
    }

    @Step("Entering Creative Name")
    public void EnterCreativeName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeName));
        driver.findElement(CreativeName).click();
        String RandomCreativeName = "Creative " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
//        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(RandomCreativeName);
    }


    @Step("Selecting Creative Type")
    public void SelectCreativeType(String CreativeType) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CreativeName)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeTypeDropDown));
        driver.findElement(CreativeTypeDropDown).click();
        driver.switchTo().activeElement().sendKeys(CreativeType);
        driver.findElement(CreativeTypeOption).click();
    }

    @Step("Selecting Campaign For")
    public void SelectCampaignFor(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignForDropdown));
        driver.findElement(CampaignForDropdown).click();
        String XpathFormatted = String.format(CampaignForOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Selecting This Template For")
    public void SelectThisTemplateFor(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ThisTemplateForDropdown));
        driver.findElement(ThisTemplateForDropdown).click();
        String XpathFormatted = String.format(ThisTemplateForDropdownOptions, option);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(XpathFormatted)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Selecting Country Code")
    public void SelectCountryCodeDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CountryCodeField));
        driver.findElement(CountryCodeField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(CountryCodeDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter  phone number dynamically ")
    public void EnterPhoneNumberDynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberField));
        driver.findElement(PhoneNumberField).click();
        WebElement element = driver.findElement(BusinessNameField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(PhoneNumberDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired phone number verification Url")
    public void EnterPhoneNumberVerificationUrlDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberVerificationUrlField));
        driver.findElement(PhoneNumberVerificationUrlField).click();

        driver.switchTo().activeElement().sendKeys("^");
        Thread.sleep(800);
        String XpathFormatted = String.format(PhoneNumberVerificationUrlDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Business name Dynamically")
    public void EnterBusinessNameDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(BusinessNameField));
        WebElement element = driver.findElement(Description1Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
        driver.findElement(BusinessNameField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(BusinessNameDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter text in first description field dynamically")
    public void EnterDescription1(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description1Field));
        WebElement element = driver.findElement(Description2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description1Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description1DynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Data In Description1 Field")
    public void EnterDataInDescription1Field(String description1) {
        WebElement element = driver.findElement(Description1Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description1Field));
        driver.findElement(Description1Field).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(description1);
    }

    @Step("Enter text in Second description field dynamically")
    public void EnterDescription2(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description2Field));
        WebElement element = driver.findElement(WebsiteUrlField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description2Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description2DynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Website Url Dynamically")
    public void EnterWebsiteUrlDynamically(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebsiteUrlField));
        WebElement element = driver.findElement(DomainField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(WebsiteUrlField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(WebsiteUrlDynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
    }

    @Step("Enter Domain Dynamically")
    public void EnterDomainDynamically(int option) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(DomainField));
        driver.findElement(DomainField).click();
        driver.switchTo().activeElement().sendKeys("^");
        Thread.sleep(500);
        String XpathFormatted = String.format(DomainDynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        WebElement element = driver.findElement(By.xpath(XpathFormatted));
        js.executeScript("arguments[0].click();", element);
    }


    @Step("Enter final URL")
    public void SelectFinalURLDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FinalURLField));
        driver.findElement(FinalURLField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(FinalURLDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Data in final URL Field")
    public void EnterFinalURL(String finalURL) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FinalURLField));
        driver.findElement(FinalURLField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(finalURL);
    }

    @Step("Enter  Display URL dynamically ")
    public void EnterDisplayURLDynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(DisplayURLField));
        driver.findElement(DisplayURLField).click();
        WebElement element = driver.findElement(HeadLine2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(DisplayURLDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Data in Display URL")
    public void EnterDataInDisplayURL(String displayURL) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DisplayURLField));
        driver.findElement(DisplayURLField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(displayURL);
    }

    @Step("Enter Headline 1")
    public void EnterHeadline1Dynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Headline1Field));
        driver.findElement(Headline1Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Headline1DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Data in Headline 2")
    public void EnterHeadline2(String headline1) {
        WebElement element = driver.findElement(HeadLine2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine2Field));
        driver.findElement(HeadLine2Field).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(headline1);
    }


    @Step("Enter  Headline 2 dynamically ")
    public void EnterHeadline2Dynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(HeadLine2Field));
        driver.findElement(HeadLine2Field).click();
        WebElement element = driver.findElement(Description1Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Headline2DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Headline 3")
    public void EnterHeadline3Dynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine3Field));
        driver.findElement(HeadLine3Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Headline3DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Headline 4")
    public void EnterHeadline4Dynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine4Field));
        driver.findElement(HeadLine4Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Headline4DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Clicking  Headline Add Button")
    public void ClickingHeadlineAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLineAddButton));
        driver.findElement(HeadLineAddButton).click();
    }

    @Step("Deleting  Headline 4")
    public void DeletingHeadline4() {
        wait.until(ExpectedConditions.elementToBeClickable(HeadLine4Field));
        driver.findElement(HeadLine4Field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine4DeleteButton));
        driver.findElement(HeadLine4DeleteButton).click();
    }

    @Step("pin Headline 4")
    public void PinHeadline4() {
        wait.until(ExpectedConditions.elementToBeClickable(HeadLine4Field));
        driver.findElement(HeadLine4Field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine4PinButton));
        driver.findElement(HeadLine4PinButton).click();
    }

    @Step("Pin Headline Position dynamically")
    public void PinPositionDynamically(int option) {
        String XpathFormatted = String.format(PinPositionDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }


    @Step("Enter text in first description field dynamically")
    public void EnterResponsiveSearchAdDescription1(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description1Field));
        WebElement element = driver.findElement(Description2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description1Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(ResponsiveSearchAdDescription1DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter text in first description field dynamically")
    public void EnterResponsiveSearchAdDescription2(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description2Field));
        WebElement element = driver.findElement(DescriptionAddButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description2Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(ResponsiveSearchAdDescription2DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter text in third description field dynamically")
    public void EnterResponsiveSearchAdDescription3(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description3Field));
        WebElement element = driver.findElement(TagField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description3Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(ResponsiveSearchAdDescription3DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Clicking  Headline Add Button")
    public void ClickingDescriptionAddButton() {
        WebElement element = driver.findElement(TagField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionAddButton));
        driver.findElement(DescriptionAddButton).click();
    }

    @Step("Deleting  Description 3")
    public void DeletingDescription3() {
        wait.until(ExpectedConditions.elementToBeClickable(Description3Field));
        driver.findElement(Description3Field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description3DeleteButton));
        driver.findElement(Description3DeleteButton).click();
    }

    @Step("pin Headline 4")
    public void PinDescription3() {
        wait.until(ExpectedConditions.elementToBeClickable(Description3Field));
        driver.findElement(Description3Field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description3PinButton));
        driver.findElement(Description3PinButton).click();
    }
//    @Step("Pin Headline Position dynamically")
//    public void PinPositionDynamically(int option) {
//        String XpathFormatted = String.format(PinPositionDynamicOptions, option);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
//        driver.findElement(By.xpath(XpathFormatted)).click();
//    }


    @Step("Validating Facebook Carousel Template Success PopUp")
    public boolean ValidateFaceBookCarouselTemplateSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookCarouselTemplateSuccessPopUp));
            return driver.findElement(FacebookCarouselTemplateSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Template Approved Status is Displayed")
    public boolean ValidateTemplateApprovedStatusIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateApprovedStatus));
            return driver.findElement(TemplateApprovedStatus).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public String FacebookProductTemplateName;

    @Step("Entering Facebook Product Template Name")
    public void EnterFacebookProductTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        FacebookProductTemplateName = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }

    public String FacebookDynamicProductTemplateName;

    @Step("Entering Facebook Product Template Name")
    public void EnterFacebookDynamicProductTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        FacebookDynamicProductTemplateName = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }


    @Step("Clicking On Select Partner")
    public void ClickOnSelectPartner() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectPartnerField));
        driver.findElement(SelectPartnerField).click();
    }


    public String GoogleSearchAd;

    @Step("Entering Google Search Ad Template Name")
    public void EnterGoogleSearchAdTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        GoogleSearchAd = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }


    @Step("Validating is Headline Field Accepts Only Spaces as Input")
    public boolean ValidateHeadlineFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(GenericHeadlineField, 1))));
            driver.findElement(By.xpath(String.format(GenericHeadlineField, 1))).click();
            driver.switchTo().activeElement().sendKeys(Keys.SPACE);
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            System.out.println("data :" + Count + ": data");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating is creative name field accepts more than 90 characters")
    public boolean ValidateCreativeNameFieldAcceptsMoreThan90Characters() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(AdTemplateName)).perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(AdTemplateName));
            driver.findElement(AdTemplateName).click();
            driver.switchTo().activeElement().sendKeys(utils.generateRandomData("randomdata", 91));
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 90;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    public String FacebookCarouselAwarenessAD;

    @Step("Entering Facebook Carousel Awareness AD Template Name")
    public void EnterFacebookCarouselAwarenessADTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        FacebookCarouselAwarenessAD = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }


    @Step("Validating Destination URL Field Empty Error Message Is Displayed")
    public boolean ValidateDestinationUrlFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DestinationUrlFieldEmptyErrorMessage));
            return driver.findElement(DestinationUrlFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate is Creative Library Choose Button is Disabled")
    public boolean ValidateCreativeLibraryChooseButtonIsDisabled() {
        String ButtonClass = driver.findElement(DisabledCreativeLibraryChooseButton).getDomAttribute("class");
        assert ButtonClass != null : "Creative Library Choose Button Class is null";
        return ButtonClass.contains("disabled");
    }


    @Step("Validating is Creative Add Tags Button is Visible")
    public boolean ValidateCreativeAddTagsButtonIsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeTagsAddButton));
            return driver.findElement(CreativeTagsAddButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    //---------------------


    @Step("Validating Tag Value Empty Error Message Is Displayed")
    public boolean ValidateTagValueEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TagValueEmptyErrorMessage));
            return driver.findElement(TagValueEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Duplicate Ad Name Error PopUp Is Displayed")
    public boolean ValidateDuplicateAdNameErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DuplicateAdNameErrorPopUp));
            return driver.findElement(DuplicateAdNameErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    public String FacebookDynamicProductAwarenessAD;

    @Step("Entering Ad Template Name")
    public void EnterFacebookDynamicProductAwarenessADTemplateName(String adTemplateName) {
        WebElement element = driver.findElement(AdTemplateName);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        FacebookDynamicProductAwarenessAD = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }


    @Step("Validating Final URL Field Empty Error Message Is Displayed")
    public boolean ValidateFinalUrlFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FinalUrlFieldEmptyErrorMessage));
            return driver.findElement(FinalUrlFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Display URL Field Empty Error Message Is Displayed")
    public boolean ValidateDisplayUrlFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DisplayUrlFieldEmptyErrorMessage));
            return driver.findElement(DisplayUrlFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline 1 Field Empty Error Message Is Displayed")
    public boolean ValidateHeadline1FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine1FieldEmptyErrorMessage));
            return driver.findElement(HeadLine1FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline 2 Field Empty Error Message Is Displayed")
    public boolean ValidateHeadline2FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine2FieldEmptyErrorMessage));
            return driver.findElement(HeadLine2FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline 3 Field Empty Error Message Is Displayed")
    public boolean ValidateHeadline3FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLine3FieldEmptyErrorMessage));
            return driver.findElement(HeadLine3FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Description 1 Field Empty Error Message Is Displayed")
    public boolean ValidateDescription1FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Description1FieldEmptyErrorMessage));
            return driver.findElement(Description1FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Description 1 Field Empty Error Message Is Displayed")
    public boolean ValidateDescription2FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Description2FieldEmptyErrorMessage));
            return driver.findElement(Description2FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Final URL Invalid URL Error Message Is Displayed")
    public boolean ValidateFinalUrlInvalidUrlErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FinalUrlInvalidUrlErrorMessage));
            return driver.findElement(FinalUrlInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Select Facebook Carousel Button")
    public void SelectGooglePerformanceMaxAds() {
        wait.until(ExpectedConditions.elementToBeClickable(GooglePerformanceMaxAdsButton));
        driver.findElement(GooglePerformanceMaxAdsButton).click();
    }

    @Step("Enter Business Name Field")
    public void SelectBusinessNameDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsBusinessNameField));
        driver.findElement(GooglePerformanceMaxAdsBusinessNameField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(BusinessNameFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Destination URL Dynamically")
    public void SelectDestinationURLDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDestinationURLField));
        driver.findElement(GooglePerformanceMaxAdsDestinationURLField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(DestinationURLFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Short Headline Dynamically")
    public void SelectShortHeadlineDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortHeadlineField));
        driver.findElement(GooglePerformanceMaxAdsShortHeadlineField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(ShortHeadlineFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Short Description Dynamically")
    public void SelectShortDescriptionDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortDescriptionField));
        driver.findElement(GooglePerformanceMaxAdsShortDescriptionField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(ShortDescriptionFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter First Headline Dynamically")
    public void SelectFirstHeadlineDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesFirstField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadlinesFirstFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Second Headline Dynamically")
    public void SelectSecondHeadlineDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesSecondField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesSecondField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadlinesSecondFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Third Headline Dynamically")
    public void SelectThirdHeadlineDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesThirdField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesThirdField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadlinesThirdFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Adding Headline ")
    public void ClickingHeadlinesAddMoreButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton).click();
    }

    @Step("Deleting Headline")
    public void HeadlinesDeletingButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesThirdFieldDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesThirdFieldDeleteButton).click();
    }

    @Step("Enter First Long Headline Dynamically")
    public void SelectFirstLongHeadlineDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesFirstField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(LongHeadlinesFirstFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Second Long Headline Dynamically")
    public void SelectSecondLongHeadlineDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesSecondField));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesSecondField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(LongHeadlinesSecondFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Adding Long Headline ")
    public void ClickingLongHeadlinesAddMoreButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton).click();
    }

    @Step("Deleting Long Headline")
    public void LongHeadlinesDeletingButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesSecondFieldDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesSecondFieldDeleteButton).click();
    }

    @Step("Enter First Description Dynamically")
    public void SelectFirstDescriptionDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsDescriptionsAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsFirstField));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsFirstField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(DescriptionsFirstFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter Second Long Headline Dynamically")
    public void SelectSecondDescriptionDynamically(int option) throws InterruptedException {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsDescriptionsAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsSecondField));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsSecondField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(DescriptionsSecondFieldDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Adding Long Headline ")
    public void ClickingDescriptionAddMoreButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsAddMoreButton).click();
    }

    @Step("Deleting Long Headline")
    public void DescriptionsDeletingButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsSecondFieldDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsSecondFieldDeleteButton).click();
    }

    @Step("Clicking On Upload first logo images")
    public void ClickOnUploadFirstLogoImages() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsLogoImagesAddMoreField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsUploadLogoImagesFirstField));
        driver.findElement(GooglePerformanceMaxAdsUploadLogoImagesFirstField).click();
    }

    @Step("Clicking On Upload Second logo images")
    public void ClickOnUploadSecondLogoImages() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsLogoImagesAddMoreField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsUploadLogoImagesSecondField));
        driver.findElement(GooglePerformanceMaxAdsUploadLogoImagesSecondField).click();
    }

    @Step("Searching tag name search field for creative library")
    public void EnteringCreativeLibrarySearchTagName(String tagName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLogoImagesCreativeLibrarySearchTagsInputField));
        driver.findElement(GooglePerformanceMaxAdsLogoImagesCreativeLibrarySearchTagsInputField).click();
        driver.switchTo().activeElement().sendKeys(tagName);

    }

    @Step("clicking on image creative library")
    public void ClickingOnTagNameImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLogoImagesCreativeLibraryFirstImage));
        driver.findElement(GooglePerformanceMaxAdsLogoImagesCreativeLibraryFirstImage).click();

    }

    @Step("Clicking On Choose Button creative library")
    public void ClickingOnCreativeLibraryChooseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLogoImagesCreativeLibraryChooseButton));
        driver.findElement(GooglePerformanceMaxAdsLogoImagesCreativeLibraryChooseButton).click();

    }

    @Step("Clicking On Choose Button creative library")
    public void ClickingOnLogoImagesAddMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLogoImagesAddMoreField));
        driver.findElement(GooglePerformanceMaxAdsLogoImagesAddMoreField).click();

    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnLogoImagesSecondDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsUploadLogoImagesSecondFieldDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsUploadLogoImagesSecondFieldDeleteButton).click();

    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnVideosAddVideoButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsVideosAddVideoButton));
        driver.findElement(GooglePerformanceMaxAdsVideosAddVideoButton).click();

    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnVideosSecondVideoDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsVideosSecondYouTubeURLDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsVideosSecondYouTubeURLDeleteButton).click();

    }

    @Step("Searching tag name search field for creative library")
    public void EnteringFirstYouTubeURL(String youTubeURL) {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsVideosAddVideoButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsVideosFirstYouTubeURLField));
        driver.findElement(GooglePerformanceMaxAdsVideosFirstYouTubeURLField).click();
        driver.switchTo().activeElement().sendKeys(youTubeURL);

    }

    @Step("Searching tag name search field for creative library")
    public void ClosingYouTubeURL() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsYouTubeURLVideoCloseButton));
        driver.findElement(GooglePerformanceMaxAdsYouTubeURLVideoCloseButton).click();

    }

    @Step("Searching tag name search field for creative library")
    public void EnteringSecondYouTubeURL(String youTubeURL) {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsVideosAddVideoButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsVideosSecondYouTubeURLField));
        driver.findElement(GooglePerformanceMaxAdsVideosSecondYouTubeURLField).click();
        driver.switchTo().activeElement().sendKeys(youTubeURL);

    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadFirstSquareMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsSquareMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsSquareMarketingFirstImage));
        driver.findElement(GooglePerformanceMaxAdsSquareMarketingFirstImage).click();
    }

    @Step("Clicking On Upload Second Square Marketing")
    public void ClickOnUploadSecondSquareMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsSquareMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsSquareMarketingSecondImage));
        driver.findElement(GooglePerformanceMaxAdsSquareMarketingSecondImage).click();
    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnSquareMarketingAddMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsSquareMarketingAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsSquareMarketingAddMoreButton).click();

    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnSquareMarketingSecondDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsSquareMarketingSecondImageDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsSquareMarketingSecondImageDeleteButton).click();

    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadFirstMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsMarketingFirstImage));
        driver.findElement(GooglePerformanceMaxAdsMarketingFirstImage).click();
    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadSecondMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsMarketingSecondImage));
        driver.findElement(GooglePerformanceMaxAdsMarketingSecondImage).click();
    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnMarketingAddMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsMarketingAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsMarketingAddMoreButton).click();

    }

    @Step("Clicking On Delete Button creative library")
    public void ClickingOnMarketingSecondDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsMarketingSecondImageDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsMarketingSecondImageDeleteButton).click();

    }

    @Step("Clicking On Optional Images Toggle Button")
    public void ClickingOnOptionalImagesToggleButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalImagesToggleButton));
        driver.findElement(GooglePerformanceMaxAdsOptionalImagesToggleButton).click();

    }

    @Step("Clicking On Optional Images Toggle Button")
    public void ClickingOnPortraitMarketingAddMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalPortraitMarketingAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingAddMoreButton).click();

    }

    @Step("Clicking On Optional Images Delete Button")
    public void ClickingOnPortraitMarketingSecondDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImageDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImageDeleteButton).click();

    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadFirstPortraitMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalPortraitMarketingFirstImage));
        driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingFirstImage).click();
    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadSecondPortraitMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImage));
        driver.findElement(GooglePerformanceMaxAdsOptionalPortraitMarketingSecondImage).click();
    }

    @Step("Clicking On Optional Images Toggle Button")
    public void ClickingOnLandscapeMarketingAddMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalLandscapeMarketingAddMoreButton));
        driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingAddMoreButton).click();

    }

    @Step("Clicking On Optional Images Delete Button")
    public void ClickingOnLandscapeMarketingSecondDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImageDeleteButton));
        driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImageDeleteButton).click();

    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadFirstLandscapeMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalLandscapeMarketingFirstImage));
        driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingFirstImage).click();
    }

    @Step("Clicking On Upload first Square Marketing")
    public void ClickOnUploadSecondLandscapeMarketingImage() {
        WebElement element = driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingAddMoreButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImage));
        driver.findElement(GooglePerformanceMaxAdsOptionalLandscapeMarketingSecondImage).click();
    }

    @Step("Click on Create Button")
    public void ClickPerformanceMaxCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(GooglePerformanceMaxAdsCreateButton));
        driver.findElement(GooglePerformanceMaxAdsCreateButton).click();
    }


    @Step("Click on Youtube Preview Button")
    public void ClickYoutubePreviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YoutubePreviewButton));
        driver.findElement(YoutubePreviewButton).click();
    }


    public String GooglePerformanceMaxAds;

    @Step("Entering Google performance Max Ad Template Name")
    public void EnterGooglePerformanceMaxAdsTemplateName(String adTemplateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdTemplateName));
        driver.findElement(AdTemplateName).click();
        GooglePerformanceMaxAds = adTemplateName;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(adTemplateName);
    }


    @Step("Validating Business Name Field Empty Error Message Is Displayed")
    public boolean ValidateBusinessNameFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BusinessNameFieldEmptyErrorMessage));
            return driver.findElement(BusinessNameFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Destination URL Field Empty Error Message Is Displayed")
    public boolean ValidateGoogleAdDestinationUrlFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleAdDestinationUrlFieldEmptyErrorMessage));
            return driver.findElement(GoogleAdDestinationUrlFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Short Headline Field Empty Error Message Is Displayed")
    public boolean ValidateShortHeadLineFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ShortHeadLineFieldEmptyErrorMessage));
            return driver.findElement(ShortHeadLineFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Short Description Field Empty Error Message Is Displayed")
    public boolean ValidateShortDescriptionFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ShortDescriptionFieldEmptyErrorMessage));
            return driver.findElement(ShortDescriptionFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline Warning Red Line Is Displayed")
    public boolean ValidateHeadlineWarningRedLine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HeadlineWarningRedLine));
            return driver.findElement(HeadlineWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline 1 Field Empty Error Message Is Displayed")
    public boolean ValidateGoogleHeadLine1FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleHeadLine1FieldEmptyErrorMessage));
            return driver.findElement(GoogleHeadLine1FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Headline 2 Field Empty Error Message Is Displayed")
    public boolean ValidateGoogleHeadLine2FieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleHeadLine2FieldEmptyErrorMessage));
            return driver.findElement(GoogleHeadLine2FieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Long Headlines Warning Red Line Is Displayed")
    public boolean ValidateLongHeadlinesWarningRedLine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LongHeadlinesWarningRedLine));
            return driver.findElement(LongHeadlinesWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Long Headline Field Empty Error Message Is Displayed")
    public boolean ValidateLongHeadLineFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LongHeadLineFieldEmptyErrorMessage));
            return driver.findElement(LongHeadLineFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Description Warning Red Line Is Displayed")
    public boolean ValidateDescriptionWarningRedLine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionFieldWarningRedLine));
            return driver.findElement(DescriptionFieldWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Description Field Empty Error Message Is Displayed")
    public boolean ValidateGoogleDescriptionFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleDescriptionFieldEmptyErrorMessage));
            return driver.findElement(GoogleDescriptionFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Logo Images Warning Red Line Is Displayed")
    public boolean ValidateLogoImagesWarningRedLine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LogoImagesWarningRedLine));
            return driver.findElement(LogoImagesWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Logo Image Field Empty Error Message Is Displayed")
    public boolean ValidateLogoImageFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LogoImageFieldEmptyErrorMessage));
            return driver.findElement(LogoImageFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Images Warning Red Line Is Displayed")
    public boolean ValidateImagesWarningRedLine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImagesFieldWarningRedLine));
            return driver.findElement(ImagesFieldWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Square Marketing Image Field Empty Error Message Is Displayed")
    public boolean ValidateSquareMarketingImageFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SquareMarketingImageFieldEmptyErrorMessage));
            return driver.findElement(SquareMarketingImageFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Marketing Image Field Empty Error Message Is Displayed")
    public boolean ValidateMarketingImageFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MarketingImageFieldEmptyErrorMessage));
            return driver.findElement(MarketingImageFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate Destination Url Field is Accepting More Than 90 Characters")
    public boolean ValidateDestinationUrlFieldAcceptingMoreThan90Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDestinationURLField));
        driver.findElement(GooglePerformanceMaxAdsDestinationURLField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 91;


    }


    @Step("Enter Data in Destination Url Field")
    public void EnterDataInDestinationUrlField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDestinationURLField));
        driver.findElement(GooglePerformanceMaxAdsDestinationURLField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Enter Data in Short Headline Field")
    public void EnterDataInShortHeadlineField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortHeadlineField));
        driver.findElement(GooglePerformanceMaxAdsShortHeadlineField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }

    @Step("Enter Data in Short Description Field")
    public void EnterDataInShortDescriptionField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortDescriptionField));
        driver.findElement(GooglePerformanceMaxAdsShortDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Enter Data in First Headline Field")
    public void EnterDataInFirstHeadlineField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesFirstField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Enter Data in Second Headline Field")
    public void EnterDataInSecondHeadlineField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesSecondField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesSecondField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Enter Data in Description Field")
    public void EnterDataInDescriptionField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsFirstField));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsFirstField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }

    @Step("Enter Data in Business Name Field")
    public void EnterDataInBusinessNameField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsBusinessNameField));
        driver.findElement(GooglePerformanceMaxAdsBusinessNameField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Validate Business Name Field is Accepting More Than 25 Characters")
    public boolean ValidateBusinessNameFieldAcceptingMoreThan25Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsBusinessNameField));
        driver.findElement(GooglePerformanceMaxAdsBusinessNameField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 27;


    }

    @Step("Validate Short Description Field is Accepting More Than 60 Characters")
    public boolean ValidateShortDescriptionFieldAcceptingMoreThan60Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortDescriptionField));
        driver.findElement(GooglePerformanceMaxAdsShortDescriptionField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 62;
    }

    @Step("Validate Short Headline Field is Accepting More Than 15 Characters")
    public boolean ValidateShortHeadlineFieldAcceptingMoreThan15Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsShortHeadlineField));
        driver.findElement(GooglePerformanceMaxAdsShortHeadlineField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 19;
    }

    @Step("Validate Headline 1 Field is Accepting More Than 30 Characters")
    public boolean ValidateHeadline1FieldAcceptingMoreThan30Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsHeadlinesFirstField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 32;
    }


    @Step("Enter Data in Long Headline Field")
    public void EnterDataInLongHeadlineField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesFirstField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Validate is Long HeadLine Field Accepts More Than 90 Characters")
    public boolean ValidateLongHeadLineFieldAcceptsMoreThan90Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesFirstField));
        driver.findElement(GooglePerformanceMaxAdsLongHeadlinesFirstField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 92;
    }


    @Step("Enter Data in Google Description Field")
    public void EnterDataInGoogleDescriptionField(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsFirstField));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsFirstField).click();
        driver.switchTo().activeElement().sendKeys(data);
    }

    @Step("Validate is Description Field is Accepting More Than 90 Characters")
    public boolean ValidateDescriptionFieldAcceptsMoreThan90Characters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsFirstField));
        driver.findElement(GooglePerformanceMaxAdsDescriptionsFirstField).click();
        return driver.switchTo().activeElement().getDomAttribute("value").length() > 92;
    }


    @Step("Validate is Headlines Add More Button is Enabled after Adding 14 Headlines")
    public boolean ValidateHeadlinesAddMoreButtonEnabledAfterAdding14Headlines() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsHeadlinesAddMoreButton));
            driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton).click();
            return driver.findElement(GooglePerformanceMaxAdsHeadlinesAddMoreButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate is Long Headlines Add More Button is Disabled after Adding 5 Headlines")
    public boolean ValidateLongHeadlinesAddMoreButtonDisabledAfterAdding5Headlines() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton));
            driver.findElement(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton).click();
            return driver.findElement(GooglePerformanceMaxAdsLongHeadlinesAddMoreButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate is Description Add More Button is Enabled after Adding 4 Descriptions")
    public boolean ValidateDescriptionAddMoreButtonEnabledAfterAdding4Descriptions() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsDescriptionsAddMoreButton));
            driver.findElement(GooglePerformanceMaxAdsDescriptionsAddMoreButton).click();
            return driver.findElement(GooglePerformanceMaxAdsDescriptionsAddMoreButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate is Logo Images Add More Button is Enabled after Adding 5 Logo Images")
    public boolean ValidateLogoImagesAddMoreButtonEnabledAfterAdding5LogoImages() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsLogoImagesAddMoreField));
            driver.findElement(GooglePerformanceMaxAdsLogoImagesAddMoreField).click();
            return driver.findElement(GooglePerformanceMaxAdsLogoImagesAddMoreField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate is Videos Add Video Button is Enabled after Adding 5 Videos")
    public boolean ValidateVideosAddVideoButtonEnabledAfterAdding5Videos() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePerformanceMaxAdsVideosAddVideoButton));
            driver.findElement(GooglePerformanceMaxAdsVideosAddVideoButton).click();
            return driver.findElement(GooglePerformanceMaxAdsVideosAddVideoButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Selecting First Template From Library Table")
    public void SelectFirstTemplateFromLibraryTable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LibraryTableFirstTemplate));
        driver.findElement(LibraryTableFirstTemplate).click();
    }


    @Step("Clicking On Archive Template Button")
    public void ClickOnArchiveTemplateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ArchiveTemplateButton));
        driver.findElement(ArchiveTemplateButton).click();
    }


    String ArchiveTemplateText;

    @Step("Entering Comments in Add Comments Text Area Field")
    public void EnterCommentsInAddCommentsTextAreaField(String comments) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommentsTextAreaField));
        driver.findElement(AddCommentsTextAreaField).click();
        ArchiveTemplateText = comments;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(comments);
    }


    @Step("Validate is Archive Template Success Popup Displayed")
    public boolean ValidateArchiveTemplateSuccessPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ArchiveTemplateSuccessPopup));
            return driver.findElement(ArchiveTemplateSuccessPopup).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking On All Actions Button")
    public void ClickOnAllActionsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AllActionsButton));
        driver.findElement(AllActionsButton).click();
    }


    @Step("Validate is Archived Template is showing in AllActions Table")
    public boolean ValidateArchivedTemplateIsShowingInAllActionsTable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AllActionsTemplateCommentText));
        return driver.findElement(AllActionsTemplateCommentText).getText().equals(ArchiveTemplateText);

    }



    @Step("Clicking On Template Review Button")
    public void ClickOnTemplateReviewButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateReviewButton));
        driver.findElement(TemplateReviewButton).click();
    }



    @Step("Validate is Under Review Template Icon Displayed in Review Table")
    public boolean ValidateUnderReviewTemplateIconDisplayedInReviewTable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ReviewTableUnderReviewTemplateIcon));
            return driver.findElement(ReviewTableUnderReviewTemplateIcon).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking On Review Text Button")
    public void ClickOnReviewTextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ReviewTextButton));
        driver.findElement(ReviewTextButton).click();
    }



    @Step("Entering Comment in Comment Field")
    public void EnterDataInCommentField(String Data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommentField));
        driver.findElement(CommentField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL+"a");
        driver.switchTo().activeElement().sendKeys(Data);
    }




    public String ReviewAdTemplateName;

    @Step("Clicking On Reject Button")
    public void ClickOnRejectButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RejectButton));
        ReviewAdTemplateName = driver.findElement(ReviewAdTemplateNameText).getText();
        System.out.println(ReviewAdTemplateName);
        driver.findElement(RejectButton).click();
    }



    @Step("Clicking On Comment And Reject Button")
    public void ClickOnCommentAndRejectButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommentAndRejectButton));
        driver.findElement(CommentAndRejectButton).click();
    }


final By CommentAndRejectSpinIcon = By.xpath("//div[contains(@class,'pendo_feature_review_comment_and_reject_button')]/descendant::i");
    @Step("Validate is Template Rejected Success Popup Displayed")
    public boolean ValidateTemplateRejectedSuccessPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(TemplateRejectedSuccessPopUp));
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateRejectedSuccessPopUp));
            return driver.findElement(TemplateRejectedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking On Filtered Pill Button")
    public void ClickOnFilteredPillButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FilteredPillButton));
        driver.findElement(FilteredPillButton).click();
    }



    @Step("Validate is Rejected Template Icon Displayed in Review Table")
    public boolean ValidateRejectedTemplateIconDisplayedInReviewTable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(RejectedTemplateText));
            return driver.findElement(RejectedTemplateText).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking On Comment Icon")
    public void ClickOnCommentIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommentIcon));
        driver.findElement(CommentIcon).click();
    }



    @Step("Clicking On Comment Only Button")
    public void ClickOnCommentOnlyButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommentOnlyButton));
        driver.findElement(CommentOnlyButton).click();
    }


    @Step("Validate is Comment Field Warning Red Line Displayed")
    public boolean ValidateCommentFieldWarningRedLineDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CommentFieldWarningRedLine));
            return driver.findElement(CommentFieldWarningRedLine).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Validate is Empty Comment is Accepted")
    public boolean ValidateEmptyCommentIsAccepted() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CommentEmptyText));
            return driver.findElement(CommentEmptyText).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking On Approve Button")
    public void ClickOnApproveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ApproveButton));
        ReviewAdTemplateName = driver.findElement(ReviewAdTemplateNameText).getText();
        driver.findElement(ApproveButton).click();
    }


    @Step("Validate is Template Approved Success Popup Displayed")
    public boolean ValidateTemplateApprovedSuccessPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateApprovedSuccessPopUp));
            return driver.findElement(TemplateApprovedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Validate is Approved Template Icon Displayed in Review Table")
    public boolean ValidateApprovedTemplateIconDisplayedInReviewTable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateApproveIcon));
            return driver.findElement(TemplateApproveIcon).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking On Add Or Remove Columns")
    public void ClickOnAddOrRemoveColumns() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddOrRemoveColumns));
        driver.findElement(AddOrRemoveColumns).click();
    }

    @Step("Selecting Table Headings in Add Or Remove Columns")
    public void SelectTableHeadingsInAddOrRemoveColumn(int Option){

        String DescriptionXpathFormatter = String.format(AddOrRemoveTableHeadingsSelector, Option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DescriptionXpathFormatter)));
        driver.findElement(By.xpath(DescriptionXpathFormatter)).click();
    }

    public int TableHeadingsCount ;
    public void DeselectTableHeadingsInAddOrRemoveColumn(int Option){
        TableHeadingsCount = driver.findElements(TableHeadings).size();
//        System.out.println("Before " +TableHeadingsCount );
        String DescriptionXpathFormatter = String.format(AddOrRemoveTableHeadingsDeselector, Option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DescriptionXpathFormatter)));
        driver.findElement(By.xpath(DescriptionXpathFormatter)).click();
    }


    @Step("Validate is Table Heading Count is Same After Deselecting Table Headings")
    public boolean ValidateTableHeadingCountIsSameAfterDeselectingTableHeadings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TableHeadings));
//        System.out.println(driver.findElements(TableHeadings).size());
//        System.out.println(driver.findElements(TableHeadings).size()== TableHeadingsCount);
        return driver.findElements(TableHeadings).size() == TableHeadingsCount;

    }



    @Step("Clicking On Table Compact View Button")
    public void ClickOnTableCompactViewButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TableCompactViewButton));
        driver.findElement(TableCompactViewButton).click();
    }



    @Step("Validate is Templates Displayed in Card View")
    public boolean ValidateTemplatesDisplayedInCardView() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplatesInCardView));
            return driver.findElement(TemplatesInCardView).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }





}