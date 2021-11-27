public class ColorComponentFactory implements AbstractFactory{

    @Override
    public Component Makecomponent() {
        return new ColorComponent();
    }
}

