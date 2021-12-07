%Number of features calculated on questions percentages and rounded up. For example 13*.9
%= 11.7 and then round up to 12
Number_of_Features = [3 4 5 6 8 9 10 12 13];

[x,t] = wine_dataset;
accuracy = [];

for i = 1:length(Number_of_Features)
    % K is the random index
    k = randperm(13,Number_of_Features(i));
    x_2 = x(k(1:Number_of_Features(i)),:);
    trainFcn = 'traingdx';
    %0.08 chosen as best learning rate based on question 1 a 
    net.trainParam.lr = 0.08;

    % Create a Pattern Recognition Network
    hiddenLayerSize = 10;
    net = patternnet(hiddenLayerSize, trainFcn);

    net.input.processFcns = {'removeconstantrows','mapminmax'};

    net.divideFcn = 'dividerand';  % Divide data randomly
    net.divideMode = 'sample';  % Divide up every sample
    net.divideParam.trainRatio = (70/100);
    net.divideParam.valRatio = 15/100;
    net.divideParam.testRatio = 15/100;

    % Choose a Performance Function
    % For a list of all performance functions type: help nnperformance
    net.performFcn = 'crossentropy';  % Cross Entropy

    % Choose Plot Functions
    % For a list of all plot functions type: help nnplot
    net.plotFcns = {'plotperform','plottrainstate','ploterrhist', ...
        'plotconfusion', 'plotroc'};

    % Train the Network
    [net,tr] = train(net,x_2,t);

    % Test the Network
    y = net(x_2);
    e = gsubtract(t,y);
    performance = perform(net,t,y)
    tind = vec2ind(t);
    yind = vec2ind(y);
    percentErrors = sum(tind ~= yind)/numel(tind);

    % Recalculate Training, Validation and Test Performance
    trainTargets = t .* tr.trainMask{1};
    valTargets = t .* tr.valMask{1};
    testTargets = t .* tr.testMask{1};
    trainPerformance = perform(net,trainTargets,y)
    valPerformance = perform(net,valTargets,y)
    testPerformance = perform(net,testTargets,y)
    

    % View the Network
    view(net)

    % Plots
    % Uncomment these lines to enable various plots.
    %figure, plotperform(tr)
    %figure, plottrainstate(tr)
    %figure, ploterrhist(e)
    %figure, plotconfusion(t,y)
    %figure, plotroc(t,y)

    % Deployment
    % Change the (false) values to (true) to enable the following code blocks.
    % See the help for each generation function for more information.
    if (false)
        % Generate MATLAB function for neural network for application
        % deployment in MATLAB scripts or with MATLAB Compiler and Builder
        % tools, or simply to examine the calculations your trained neural
        % network performs.
        genFunction(net,'myNeuralNetworkFunction');
        y = myNeuralNetworkFunction(x_2);
    end
    if (false)
        % Generate a matrix-only MATLAB function for neural network code
        % generation with MATLAB Coder tools.
        genFunction(net,'myNeuralNetworkFunction','MatrixOnly','yes');
        y = myNeuralNetworkFunction(x_2);
    end
    if (false)
        % Generate a Simulink diagram for simulation or deployment with.
        % Simulink Coder tools.
        gensim(net);
    end
    
    accuracy(i) = 1 - confusion(t,y);
end 
%Accuracy hand picked from
%accuracy[,177/178]
plot([Number_of_Features(end) Number_of_Features], [accuracy(end) accuracy], 'r-');