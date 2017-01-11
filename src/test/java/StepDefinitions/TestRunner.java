package StepDefinitions;

import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.AbsolutePathCalculator;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.PrintStreamStepdocReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepFinder;

import com.thoughtworks.paranamer.NullParanamer;

import net.serenitybdd.jbehave.SerenityStories;

//@RunWith(SerenityReportingRunner.class)
public class TestRunner extends SerenityStories{
	private Configuration configuration;


	public TestRunner() {
		super();
		configuration = new Configuration() {
		};

		configuration.useFailureStrategy(new RethrowingFailure());
		configuration.useKeywords(new LocalizedKeywords(Locale.ENGLISH));
		configuration.usePathCalculator(new AbsolutePathCalculator());
		configuration.useParameterControls(new ParameterControls());
		configuration.useParameterConverters(new ParameterConverters());
		configuration.useParanamer(new NullParanamer());
		configuration.usePendingStepStrategy(new PassingUponPendingStep());
		configuration.useStepCollector(new MarkUnmatchedStepsAsPending());
		configuration.useStepdocReporter(new PrintStreamStepdocReporter());
		configuration.useStepFinder(new StepFinder());
		configuration.useStepMonitor(new SilentStepMonitor());
		configuration.useStepPatternParser(new RegexPrefixCapturingPatternParser());
		configuration.useStoryControls(new StoryControls());
		configuration.useStoryLoader(new LoadFromClasspath());
		configuration.useStoryParser(new RegexStoryParser(configuration.keywords()));
		configuration.useStoryPathResolver(new UnderscoredCamelCaseResolver());
		configuration.useStoryReporterBuilder(new StoryReporterBuilder().withFormats( Format.CONSOLE, Format.STATS, Format.HTML ));
		configuration.useViewGenerator(new FreemarkerViewGenerator());
		
		EmbedderControls embedderControls = configuredEmbedder().embedderControls();
		embedderControls.doBatch(true);
		embedderControls.doGenerateViewAfterStories(true);
		embedderControls.doIgnoreFailureInStories(true);
		embedderControls.doIgnoreFailureInView(false);
		embedderControls.doIgnoreFailureInStories(true);
		embedderControls.doSkip(false);
		embedderControls.doVerboseFailures(false);
		embedderControls.doVerboseFiltering(false);
		embedderControls.useStoryTimeouts("10000");

	}
	@Override
	public Configuration configuration() {

		return configuration;
	}
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), 
				new LoginSteps(),
				new CreateAccountSteps(),
				new One20CredentialsSteps(),
				new UpdateProfileInformationSteps(),
				new UpdateTruckInfoSteps(),
				new POIMoreInfoSteps(), 
				new ContactUsSteps(),
				/*new PartnersSteps(),*/
				new DealsSteps()
				);
	}
	@Override
	public List<String> storyPaths()
	{
		StoryFinder finder = new StoryFinder();
		return finder.findPaths(CodeLocations.codeLocationFromPath("src/test/resources"), "stories/*.story","");

		//return Arrays.asList("FitnessFirstSmokeTest/src/test/java/features/login.story");
	}
}
